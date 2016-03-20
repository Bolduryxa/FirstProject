package com.Vladic.Bolduryxa.NewImplementation.configurationhandlers;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;


public class ConfigurationHandlersTest {

    @Test
    public void testLoad() throws Exception {
        ConfigurationHandlers configuration = new ConfigurationHandlers();

        try(InputStream inputStream = new ByteArrayInputStream((
                "   |     inFor     |     general        |\n" +
                "---+---------------+--------------------+\n" +
                " { |  syntaxError  |  LeftBraceHandler  |\n" +
                " } |  syntaxError  |  RightBraceHandler |"/* +
                "---+---------------+--------------------+\n"*/).getBytes())){
            configuration.load( inputStream);
            assertEquals( "syntaxError", configuration.getParametr( "{", "inFor"));
            assertEquals( "LeftBraceHandler", configuration.getParametr( "{", "general"));
            assertEquals( "syntaxError", configuration.getParametr( "}", "inFor"));
            assertEquals( "RightBraceHandler", configuration.getParametr( "}", "general"));
        }
    }
}