package com.Vladic.Bolduryxa.NewImplementation.configurationhandlers;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;


public class ConfigurationHandlersTest {

  /*  @Test
    public void testLoad() throws Exception {
        ConfigurationHandlers configuration = new ConfigurationHandlers();

        try(InputStream inputStream = new ByteArrayInputStream((
                "   |     inForHandler     |     general        |\n" +
                "---+---------------+--------------------+\n" +
                " { |  syntaxError  |  LeftBraceHandler  |\n" +
                " } |  syntaxError  |  RightBraceHandler |"*//* +
                "---+---------------+--------------------+\n"*//*).getBytes())){
            configuration.load( inputStream);
            assertEquals( "syntaxError", configuration.getParameter( "{", "inFor"));
            assertEquals( "LeftBraceHandler", configuration.getParameter( "{", "general"));
            assertEquals( "syntaxError", configuration.getParameter( "}", "inFor"));
            assertEquals( "RightBraceHandler", configuration.getParameter( "}", "general"));
        }
    }*/
}