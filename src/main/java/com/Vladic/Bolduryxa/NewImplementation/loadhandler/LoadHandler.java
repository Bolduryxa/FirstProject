package com.Vladic.Bolduryxa.NewImplementation.loadhandler;

import com.Vladic.Bolduryxa.NewImplementation.facadlogger.Facad;
import com.Vladic.Bolduryxa.NewImplementation.facadlogger.IFacad;
import com.Vladic.Bolduryxa.NewImplementation.factorymethod.HandlerFactory;
import com.Vladic.Bolduryxa.NewImplementation.factorymethod.HandlerFactoryException;
import com.Vladic.Bolduryxa.NewImplementation.formatter.FormatterException;
import com.Vladic.Bolduryxa.NewImplementation.getargumentshandler.GetArgumentsHandler;
import com.Vladic.Bolduryxa.NewImplementation.handlers.IHandler;

import java.util.Properties;

/**
 * Created by bolduryxa on 13.05.16.

 */
public class LoadHandler {
    private static final IFacad logger = Facad.getLogger(LoadHandler.class);
    private Properties configHandlers;
    private String hadlerName;
    private GetArgumentsHandler getArgumentsHandler;
    private HandlerFactory handlerFactory;

    /**
     *
     * @param configHandlers 'configHandlers'
     * @param handlerName 'handlerName'
     */
    public LoadHandler(final Properties configHandlers, final String handlerName) {
        this.configHandlers = configHandlers;
        this.hadlerName = handlerName;
        getArgumentsHandler = new GetArgumentsHandler(configHandlers, handlerName);
        handlerFactory = new HandlerFactory();
    }
    /**
     *
     * @param configHandlers 'configHandlers'
     * @param handlerName 'handlerName'
     * @return
     */
    public IHandler loadHandler(final Properties configHandlers, final String handlerName) {
        logger.debug(String.format("Loading handler '%s'", handlerName));
        Object[] argv = getArgumentsHandler.getArgumentsHandler(configHandlers, handlerName);
        try{
            IHandler handler = handlerFactory.getObject(configHandlers.getProperty(handlerName), argv);
            logger.info(String.format("Loaded handler '%s'", handlerName));
            return handler;
        } catch (HandlerFactoryException ex){
            logger.error(String.format("Can't loaded handler '%s'", handlerName));
            throw new FormatterException(ex);
        }
    }
}
