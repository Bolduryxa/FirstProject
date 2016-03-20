package com.Vladic.Bolduryxa.NewImplementation;

import com.Vladic.Bolduryxa.NewImplementation.Formatter.Formatter;
import com.Vladic.Bolduryxa.NewImplementation.Formatter.FormatterException;
import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_Handler;
import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_InputStream;
import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_OutputStream;
import com.Vladic.Bolduryxa.NewImplementation.Load.Load;
import com.Vladic.Bolduryxa.NewImplementation.State.State;
import com.Vladic.Bolduryxa.NewImplementation.Streams.FileInputStreams;
import com.Vladic.Bolduryxa.NewImplementation.Streams.FileOutputStreams;
import org.apache.log4j.Logger;

import java.io.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Main {
    /*private  static final  Logger logger = Logger.getLogger(Main.class);
    //private  static final  IFacad logger = Facad.getLogger(Main.class);

    Formatter formatter;
    private void loadProperties (Properties properties, String  filename ) {
        //java.io.InputStream inputStream = null;
        BufferedReader inputStream = null;
        try {
            inputStream = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
                    //Main.class.getClassLoader().getResourceAsStream( filename);
                inputStream.
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

                //logger.error( "File not found '{}'", filename);// not look filename
                logger.error( String.format("File not found '%s'", filename));
                System.exit( 1 );
            }
        }
    }
    public Main (String[] argv) {

        Properties formatterConfig = new Properties();
        Properties statetable = new Properties();
        Properties handlers = new Properties();
        String configurationFileName = "config.properties";
        String statetableFileName = "statetable.properties";
        String handlersFileName = "handlers.properties";

        loadProperties(formatterConfig,configurationFileName);
        loadProperties(statetable,statetableFileName);
        loadProperties(handlers,handlersFileName);
        Map<String,Map<String,String>> map = new HashMap<>();
        Map<String,Map<Load,Load>> map1 =

        try {
            formatter = new Formatter( map);

        } catch ( FormatterException e){
            Throwable cause = e;
            while( cause != null){
                logger.error( cause.getMessage());
                cause = cause.getCause();
            }
            System.exit( 2);

        }

    }
    public void start() {
        try {
            I_InputStream inputStream = new FileInputStreams( "input.txt");
            I_OutputStream outputStream = new FileOutputStreams( "output.txt");
            formatter.execute(inputStream, outputStream);
        }catch ( FormatterException e){
            Throwable cause = e;
            while( cause != null){
                logger.error( cause.getMessage());
                cause = cause.getCause();
            }
            System.exit( 2);
        }
        //formatter.execute();
    }
public static void main(String[] argv) {
    new Main( argv).start();
}*/
}

