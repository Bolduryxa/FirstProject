package com.Vladic.Bolduryxa.NewImplementation.Formatter;


import com.Vladic.Bolduryxa.NewImplementation.FactoryMethod.HandlerFactory;
import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_Handler;
import com.Vladic.Bolduryxa.NewImplementation.State.State;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Formatter {

    private static final Logger logger = Logger.getLogger(Formatter.class);
    private ReentrantReadWriteLock lock;
    private Lock writeLock;
    private Lock readLock;
    private HandlerFactory handlerFactory;
    private Map<String,Map<String,String>> stateObjc;
    private  Map<String,String> handlers;
    /*
    private I_InputStream inputStream;
    private I_OutputStream outputStream;
    private I_Handler [] iHandlers;
    private Boolean isFirst;{
        isFirst=true;

    }*/
/*
    public void initProperties(Properties properties){
        if ( isFirst){
            isFirst = false;
        }else{
            close();
        }
        initInterfaceInputStream( properties);
        initInterfaceOutputStream( properties);
        initInterfaceHandlers( properties);
    }*/

    public Formatter( Map<String,Map<State,I_Handler>> map) {
        lock = new ReentrantReadWriteLock();
        writeLock = lock.writeLock();//все берет потоки
        readLock = lock.readLock();// берет один поток
        handlerFactory = new HandlerFactory();
        stateObjc = new HashMap<>();
        handlers = new HashMap<>();
        initialization( map);

    }

    private void initialization(Map<String, Map<State, I_Handler>> map) {
        writeLock.lock();
        handlers.clear();
//        for ()

    }



    /*public void execute() {
        logger.info( "Formatter starting");
        boolean exit;
        char inputChar;
        int variable;
        try {
            while (inputStream.hasNext()) {
                exit = false;
                inputChar = inputStream.read();
                for (int i = 0; i < iHandlers.length && !exit; ++i)
                    exit = iHandlers[i].execute(inputChar, outputStream);
                try {
                    variable = (char) (1 / new Boolean(exit).compareTo(Boolean.valueOf("false")));
                } catch (ArithmeticException e) {
                    outputStream.write(inputChar);
                }
            }
        }catch ( InputStreamException | OutputStreamException e){
            throw new FormatterException( "IO Exception", e);
        }
        logger.info( "Formatting finished");
    }*/

  /*  private void initInterfaceInputStream(Properties properties){
        logger.info("InterfaceInputStream loading_");
        String classInterfaceInputStreamName = properties.getProperty("InterfaceInputStream");
        InputStreamFactory i_inputStreamFactory = new InputStreamFactory();
        try {
            int countArguments = Integer.valueOf(properties.getProperty("InterfaceInputStream.countArguments"));
            String[] argvInterfaceInputStream = new String[countArguments];
            for( int i=0; i<countArguments; ++i)
                argvInterfaceInputStream[i] = properties.getProperty( "InterfaceInputStream.argument" + (i+1));
            try{
                inputStream = i_inputStreamFactory.getInterfaceInputStream( classInterfaceInputStreamName, argvInterfaceInputStream);
                logger.info( "InterfaceInputStream loaded.");
            }catch ( OFactoryException e){
                throw new FormatterException( "Error create InterfaceInputStream", e);
            }
        }catch ( NumberFormatException | NegativeArraySizeException ex){
            try{
                inputStream = i_inputStreamFactory.getInterfaceInputStream( classInterfaceInputStreamName);
            }catch ( OFactoryException e){
                throw new FormatterException( "Error create InterfaceInputStream", e);
            }
        }
    }*/

  /*  private void initInterfaceOutputStream( Properties properties){
        logger.info( "InterfaceOutputStream loading_");
        String classInterfaceOutputStreamName = properties.getProperty( "InterfaceOutputStream");
        OutputStreamFactory i_outputStreamFactory = new OutputStreamFactory();
        try {
            int countArguments = Integer.valueOf(properties.getProperty("InterfaceOutputStream.countArguments"));
            String[] argvInterfaceOutputStream = new String[countArguments];
            for( int i=0; i<countArguments; ++i)
                argvInterfaceOutputStream[i] = properties.getProperty( "InterfaceOutputStream.argument" + (i+1));
            try{
                outputStream = i_outputStreamFactory.getInterfaceOutputStream( classInterfaceOutputStreamName, argvInterfaceOutputStream);
                logger.info( "InterfaceOutputStream loaded.");
            }catch ( OFactoryException e){
                throw new FormatterException( "Error create InterfaceOutputStream", e);
            }
        }catch ( NumberFormatException | NegativeArraySizeException exception){
            try{
                outputStream = i_outputStreamFactory.getInterfaceOutputStream( classInterfaceOutputStreamName);
            }catch ( OFactoryException e){
                throw new FormatterException( "Error create InterfaceOutputStream", e);
            }
        }
    }
*/
   /* private void initInterfaceHandlers( Properties properties) {
        logger.info( "InterfaceHandlers loading_");
        int countHandlers;
        try{
            countHandlers = Integer.valueOf( properties.getProperty( "InterfaceHandlersCount"));
        }catch ( NumberFormatException exception) {
            countHandlers = 0;
        }catch (NegativeArraySizeException exception){
            throw new FormatterException( "Error  create handlers", exception);
        }

        iHandlers = new I_Handler[countHandlers];
        HandlerFactory i_handlerFactory = new HandlerFactory();
        for( int i=0; i<countHandlers; ++i) {
            String handlerName = properties.getProperty( "InterfaceHandler"+(i+1));
            try{
                int countArguments = Integer.valueOf(properties.getProperty(handlerName+".countArguments"));
                String[] argvInterfaceHandlers = new String[countArguments];
                for( int j=0; j<countArguments; ++j)
                    argvInterfaceHandlers[j] = properties.getProperty( handlerName+".argument."+(j+1));
                try{
                    iHandlers[i] = i_handlerFactory.getInterfaceHandler( handlerName, argvInterfaceHandlers);
                }catch( OFactoryException e){
                    throw new FormatterException( "Error  create InterfaceHandler", e);
                }
            }catch ( NumberFormatException | NegativeArraySizeException exception){
                try{
                    iHandlers[i] = i_handlerFactory.getInterfaceHandler( handlerName);
                }catch( OFactoryException e){
                    throw new FormatterException( "Error create InterfaceHandler", e);
                }
            }
        }
        logger.info( countHandlers + "loaded handlers");
    }*/


   /* private void close() {
        try {
            inputStream.close();
        } catch (InputStreamException e) {
            throw new FormatterException(e);
        }
            try {
            outputStream.close();
        } catch(OutputStreamException ex) {
            throw new FormatterException(ex);
        }

    }*/


}
