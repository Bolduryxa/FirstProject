package com.Vladic.Bolduryxa.NewImplementation;

import com.Vladic.Bolduryxa.NewImplementation.Formatter.Formatter;
import com.Vladic.Bolduryxa.NewImplementation.Formatter.FormatterException;
import org.apache.log4j.Logger;

import java.io.*;

import java.util.Properties;

public class Main {
    private  static final  Logger logger = Logger.getLogger(Main.class);
    //private  static final  IFacad logger = Facad.getLogger(Main.class);

    Formatter formatter;
    public Main(String[] argv){

        Properties properties = new Properties();
        InputStream fis;
        //загрузка файла с properties
        try {
            fis = Main.class.getClassLoader().getResourceAsStream( "config.properties");
            properties.load(fis);
        //    properties.load(new InputStreamReader(new FileInputStream("config.properties"), "UTF-8"));
        } catch (IOException e) {
            logger.error("File not found ");
            System.exit( 1);
        }

        try {
            formatter = new Formatter( properties);
        }catch ( FormatterException e){
            Throwable cause = e;
            while( cause != null){
                logger.error( cause.getMessage());
                cause = cause.getCause();
            }
            System.exit( 2);

        }

    }
    public void start(){
        formatter.execute();
    }
public static void main(String[] argv) {
    new Main( argv).start();
}
}

