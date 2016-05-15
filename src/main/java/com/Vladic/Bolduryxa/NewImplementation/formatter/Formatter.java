package com.Vladic.Bolduryxa.NewImplementation.formatter;


import com.Vladic.Bolduryxa.NewImplementation.configurationhandlers.ConfigurationHandlers;
import com.Vladic.Bolduryxa.NewImplementation.facadlogger.Facad;
import com.Vladic.Bolduryxa.NewImplementation.facadlogger.IFacad;
import com.Vladic.Bolduryxa.NewImplementation.fileinputstreams.IInputStream;
import com.Vladic.Bolduryxa.NewImplementation.fileoutputstreams.IOutputStream;
import com.Vladic.Bolduryxa.NewImplementation.handlers.IHandler;
import com.Vladic.Bolduryxa.NewImplementation.ishandler.IsHandler;
import com.Vladic.Bolduryxa.NewImplementation.loadhandler.LoadHandler;
import com.Vladic.Bolduryxa.NewImplementation.tokenaizer.Tokenizer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 */
public class Formatter {


    private static final IFacad logger = Facad.getLogger(Formatter.class);
    private Map<String, IHandler> handlers;
    private Map<String, IHandler> containerObjects;
    private String state;
    private ConfigurationHandlers configurationHandlers;
    private ConfigurationHandlers configurationNextHandlers;
    private LoadHandler loadHandler;
    private IsHandler isHandler;
    private Tokenizer tokenizer;
    /**
     *
     * @param configHandlers 'configHandlers'
     * @param configTableHandlers 'configTableHandlers'
     */
    public Formatter(final Properties configHandlers, final ConfigurationHandlers configTableHandlers, final ConfigurationHandlers configTableNextHandlers)  {
        isHandler = new IsHandler();
        handlers = new HashMap<>();
        containerObjects = new HashMap<>();
        initialization(configHandlers, configTableHandlers, configTableNextHandlers);
    }

    /**
     *
     * @param inputstream input stream
     * @param outputstream output stream
     * @param tokenizer tokenizer
     */
 public void execute(final IInputStream inputstream, final IOutputStream outputstream, final Tokenizer tokenizer) {
     logger.info("formatter starting");
     String output = null;
     state = "general";
      while (inputstream.hasNext() || tokenizer.hasNext()) {
         String token;
          if (inputstream.hasNext()) token = String.valueOf(inputstream.read());
            else token = tokenizer.getToken();

          token = tokenizer.searchHandlerForTheToken(token, isHandler);
          if (isHandler.getIsHanler()) {

              IHandler handler = handlers.get(configurationHandlers.getParameter(token, state));
              output = handler.execute(token);
              state = configurationNextHandlers.getParameter(token, state);
              if (state == null) state = "general";
              outputstream.write(output);
          }
     }
     logger.info("Formatting finished");
    }

    /**
     *
     * @param configHandlers 'confighandlers'
     * @param configTableHandlers 'configTableHandlers'
     */
    private void initialization(final Properties configHandlers, final ConfigurationHandlers configTableHandlers, final ConfigurationHandlers configTableNextHandlers) {
        this.configurationHandlers = configTableHandlers;
        this.configurationNextHandlers = configTableNextHandlers;
        handlers.clear();
        state = "general";
        for (String handlerName : configHandlers.stringPropertyNames()) {
            IHandler handler = getHandler(configHandlers, handlerName);
            handlers.put(handlerName, handler);
        }
    }

    /**
     *
     * @param configHandlers 'confighandlers'
     * @param handlerName 'handlerName'
     * @return
     */
    public IHandler getHandler(final Properties configHandlers, final String handlerName) {
        loadHandler = new LoadHandler(configHandlers, handlerName);
        IHandler handler =  containerObjects.get(handlerName);
        if (handler == null) {
            handler = loadHandler.loadHandler(configHandlers, handlerName);
            containerObjects.put(handlerName, handler);
        }
        return handler;
    }

}
