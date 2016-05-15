package com.Vladic.Bolduryxa.NewImplementation.getargumentshandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by bolduryxa on 13.05.16.
 */
public class GetArgumentsHandler {
    private  Properties configHandlers;
    private  String hadlerName;
    public GetArgumentsHandler(final Properties configHandlers, final String handlerName) {
        this.configHandlers = configHandlers;
        this.hadlerName = handlerName;
    }
    /**
     *
     * @param configHandlers 'configHandlers'
     * @param handlerName 'handlerName'
     * @return
     */
    public Object[] getArgumentsHandler(final Properties configHandlers, final String handlerName) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(handlerName).append('.');
        String startHandlerArgumentName = stringBuilder.toString();
        String endsHandlerArgumentName = ".type";
        List<Object> list = new ArrayList<>();
        for (String argv: configHandlers.stringPropertyNames()) {
            if (argv.startsWith(startHandlerArgumentName)){
                if (argv.endsWith(endsHandlerArgumentName)) continue;
                String value = configHandlers.getProperty(argv);
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(argv).append(endsHandlerArgumentName);
                switch (configHandlers.getProperty(stringBuilder.toString())){
                    case "Integer":
                        list.add(Integer.valueOf(value));
                        break;
                    case "String":
                    default:
                        list.add(value);
                        break;
                }
            }
        }
        return list.toArray();
    }

}
