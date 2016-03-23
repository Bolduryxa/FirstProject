package com.Vladic.Bolduryxa.NewImplementation;

import com.Vladic.Bolduryxa.NewImplementation.Formatter.Formatter;
import com.Vladic.Bolduryxa.NewImplementation.Formatter.FormatterException;
import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_InputStream;
import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_OutputStream;
import com.Vladic.Bolduryxa.NewImplementation.Streams.FileInputStreams;
import com.Vladic.Bolduryxa.NewImplementation.Streams.FileOutputStreams;
import com.Vladic.Bolduryxa.NewImplementation.configurationhandlers.ConfigurationHandlers;
import com.Vladic.Bolduryxa.NewImplementation.tokenizer.Tokenizer;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    private  static final  Logger logger = Logger.getLogger(Main.class);
    //private  static final  IFacad logger = Facad.getLogger(Main.class);

    Formatter formatter;
    private Tokenizer tokenizer;
    private void loadProperties (Properties properties, String  filename ) {

        InputStream inputStream = null;
        try {
            inputStream = Main.class.getClassLoader().getResourceAsStream( filename);

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

        Properties confighandlers = new Properties();
        InputStream configurationStateFileName = Main.class.getClassLoader().getResourceAsStream("ConfigState.table");
        String handlersFileName = "handlers.properties";
        ConfigurationHandlers configTableHandlers = new ConfigurationHandlers();
        configTableHandlers.load(configurationStateFileName);
        loadProperties(confighandlers,handlersFileName);

        tokenizer = new Tokenizer();
        try {
            formatter = new Formatter( confighandlers,configTableHandlers );

        } catch ( FormatterException e){
            logger.error( e.getMessage());
            System.exit( 2);

        }

    }
    public void start() {
        try {
            I_InputStream inputStream = new FileInputStreams( "input.txt");
            I_OutputStream outputStream = new FileOutputStreams( "output.txt");
            formatter.execute(inputStream, outputStream,tokenizer);
        }catch ( FormatterException e){
            Throwable cause = e;
            while( cause != null){
                logger.error( cause.getMessage());
                cause = cause.getCause();
            }
            System.exit( 2);
        }

    }
public static void main(String[] argv) {
    new Main( argv).start();
}
}

