package com.Vladic.Bolduryxa.NewImplementation.Load;


import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Load {
    private  static final Logger logger = Logger.getLogger(Load.class);

    private void loadProperties (Properties properties, String  filename ) {
        java.io.InputStream inputStream = null;
        try {
            inputStream = Load.class.getClassLoader().getResourceAsStream( filename);

            properties.load( inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();


                logger.error( String.format("File not found '%s'", filename));
                System.exit( 1 );
            }
        }
    }
    Properties statetable = new Properties();
    Properties handlers = new Properties();
    Properties formatterConfig = new Properties();
    String configurationFileName = "config.properties";
    String statetableFileName = "statetable.properties";
    String handlersFileName = "handlers.properties";
    public  Load () {
        loadProperties(formatterConfig, configurationFileName);
        loadProperties(statetable, statetableFileName);
        loadProperties(handlers, handlersFileName);

    }

}
