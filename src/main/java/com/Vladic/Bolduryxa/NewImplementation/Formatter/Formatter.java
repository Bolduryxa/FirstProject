package com.Vladic.Bolduryxa.NewImplementation.Formatter;


import com.Vladic.Bolduryxa.NewImplementation.Exception.HandlerFactoryException;
import com.Vladic.Bolduryxa.NewImplementation.FactoryMethod.HandlerFactory;
import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_Handler;
import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_InputStream;
import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_OutputStream;
import com.Vladic.Bolduryxa.NewImplementation.State.State;
import com.Vladic.Bolduryxa.NewImplementation.configurationhandlers.ConfigurationHandlers;
import com.Vladic.Bolduryxa.NewImplementation.tokenizer.Tokenizer;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Handler;

public class Formatter {

    private static final Logger logger = Logger.getLogger(Formatter.class);
    private ReentrantReadWriteLock lock;
    private Lock writeLock;
    private Lock readLock;
    private HandlerFactory handlerFactory;
    private  Map<String,I_Handler> handlers;
    private Map<String, I_Handler> containerObjects;
    private String state;
    private ConfigurationHandlers configurationHandlers;


    public Formatter(Properties confighandlers, ConfigurationHandlers configTableHandlers)  {
        lock = new ReentrantReadWriteLock();
        writeLock = lock.writeLock();//все берет потоки
        readLock = lock.readLock();// берет один поток
        handlerFactory = new HandlerFactory();
        handlers = new HashMap<>();
        containerObjects = new HashMap<>();
        initialization(confighandlers,configTableHandlers);

    }
 public void execute(I_InputStream inputstream, I_OutputStream outputstream, Tokenizer tokenizer) {
     readLock.lock();//никакой поток не блокировался на запись,идем дальше+иначе ждем пока закончится запись
     logger.info( "Formatter starting");
     String output = null;
     while( inputstream.hasNext()) {
         String token = tokenizer.nextToken( inputstream);

         I_Handler handler = handlers.get(configurationHandlers.getParametr(token,state));
         if( handler == null){
             output = token;
         } else {
             output = handler.execute(state);
         }
         outputstream.write( output);
     }
     logger.info( "Formatting finished");
     readLock.unlock();

    }


    private void initialization(Properties confighandlers, ConfigurationHandlers configTableHandlers) {
        writeLock.lock();
        this.configurationHandlers = configTableHandlers;
        handlers.clear();
        state = "general";
        for ( String handlerName : confighandlers.stringPropertyNames()) {
            I_Handler handler = getHandler(confighandlers,handlerName);
            handlers.put(handlerName, handler);
        }
        writeLock.unlock();

    }
    public I_Handler getHandler(Properties confighandlers,String handlerName) {

        I_Handler handler =  containerObjects.get( handlerName);
        if( handler == null) {
            handler = loadHandler( confighandlers, handlerName);
            containerObjects.put( handlerName, handler);
        }
        return handler;
    }
    private I_Handler loadHandler( Properties confighandlers, String handlerName) {
        logger.debug(String.format("Loading handler '%s'", handlerName));
        Object[] argv = getArgumentsHandler( confighandlers, handlerName);
        try{
            I_Handler handler = handlerFactory.getObject( confighandlers.getProperty( handlerName), argv);
            logger.info(String.format ("Loaded handler '%s'", handlerName));
            return handler;
        } catch ( HandlerFactoryException ex){
            logger.error(String.format ("Can't loaded handler '%s'", handlerName));
            throw new FormatterException( ex);
        }
    }
    private Object[] getArgumentsHandler(Properties confighandlers, String handlerName) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( handlerName).append( '.');
        String startHandlerArgumentName = stringBuilder.toString();
        String endsHandlerArgumentName = ".type";
        List<Object> list = new ArrayList<>();
        for( String argv: confighandlers.stringPropertyNames()) {
            if( argv.startsWith( startHandlerArgumentName)){
                if( argv.endsWith( endsHandlerArgumentName)) continue;
                String value = confighandlers.getProperty( argv);
                stringBuilder.delete( 0, stringBuilder.length());
                stringBuilder.append( argv).append( endsHandlerArgumentName);
                switch ( confighandlers.getProperty( stringBuilder.toString())){
                    case "Integer":
                        list.add( Integer.valueOf( value));
                        break;
                    case "String":
                    default:
                        list.add( value);
                        break;
                }
            }
        }
        return list.toArray();
    }







}
