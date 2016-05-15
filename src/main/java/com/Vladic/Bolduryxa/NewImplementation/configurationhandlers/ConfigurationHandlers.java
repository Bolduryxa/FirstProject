package com.Vladic.Bolduryxa.NewImplementation.configurationhandlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 *
 */
public class ConfigurationHandlers {
    /**
     *
     */
    private final Map<String, Map<String, String>> table;

    /**
     *
     */
    public ConfigurationHandlers() {
        this.table = new HashMap<>();
    }

    /**
     *
     * @param key1 'key1'
     * @param key2 'key2'
     * @return
     */
    public String getParameter(final String key1, final  String key2){
        return table.computeIfAbsent(key1, new Function<String, Map<String, String>>() {
            @Override
            public Map<String, String> apply(final String s) {
                return table.get("define");
            }
        }).get(key2);
/*

        Map<String, String> line = table.get(key1);
        if (line != null) {
            return line.get(key2);
        }
        return null;
*/
    }

    /**
     *
     * @param stream 'stream.'
     */
    public void load(final InputStream stream){
        table.clear();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        try {
            String line = reader.readLine();
            String[] keys = line.split("[|]");
            String[] keysName = new String[keys.length - 1];
            int size = keys.length - 1;
            for (int i = 0; i < size; ++i) {
                keysName[i] = keys[i + 1].trim();
            }
            reader.readLine();
            Map<String, String> lineValue;
            while ((line = reader.readLine()) != null) {
                if (line.equals("")) {
                    return;
                }

                keys = line.split("[|]");
                //if (keys.length -1 != size) {
                if (keys.length  != size) {
                    throw new RuntimeException();
                }
                lineValue = new HashMap<String, String>();
                for (int i = 0; i < size; ++i){
                    //lineValue.put(keysName[i], keys[i + 1].trim());
                    lineValue.put(keysName[i], keys[i ].trim());
                }
                table.put(keys[0].trim(), lineValue);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}

