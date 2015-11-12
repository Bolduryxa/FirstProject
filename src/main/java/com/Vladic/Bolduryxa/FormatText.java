package com.Vladic.Bolduryxa;

import com.Vladic.Bolduryxa.Stream.*;
import com.Vladic.Bolduryxa.Stream.I_OutputText;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;

/**
 * Created by Vladiclav on 31.10.2015.
 */
public class FormatText {

    public static final Logger logger = Logger.getLogger( FormatText.class);

    private I_InputText inStream;
    private I_OutputText outStream;
    private Token token;
    private Properties property;
    private int TAB_SIZE;

    public FormatText( I_InputText stream, I_OutputText outStream) throws FormatterException {
        this.inStream = stream;
        this.outStream = outStream;
        this.property = new Properties();
        try( InputStream is = this.getClass().getClassLoader().getResourceAsStream( "config.properties")) {
            property.load( is);
            TAB_SIZE = Integer.valueOf(property.getProperty("TAB_SIZE", "4"));
        }catch( FileNotFoundException | NullPointerException e) {
             throw new FormatterException("File not found",e);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void format(){
        logger.info("Initialization formater...");
        token = new Token( inStream);
        for( String key: property.keySet().toArray( new String[0])) {
            if (!key.equals("TAB_SIZE")) {
                property.setProperty( key, property.getProperty( key).substring( 0, property.getProperty( key).length()-1));
                token.add(key);
            }
            //System.out.println( "\""+key+"\"");
        }
        int tab = 0;
        boolean isNewLine = false;
        logger.info("Formated...");
        while ( !token.isEnd()) {
            token.next();

            /**********************************************************/
            if( token.getToken().equals( "{")) ++tab;
            if( token.getToken().equals( "}")) --tab;
            /**********************************************************/

            if (isNewLine) {
                for (int i = 0; i < TAB_SIZE*tab; ++i)
                    outStream.write(' ');
                isNewLine = false;
            }

            /**
             * small structure for formatting of a code
             */
            if( property.getProperty( token.getToken()) != null){
                if( property.getProperty( token.getToken()).endsWith( "\n"))
                    isNewLine = true;
                outStream.write(property.getProperty(token.getToken()));
                if( token.isSkipSpaces() || token.isNextLine()) outStream.write( ' ');
            }else{
                outStream.write( token.getToken());
                if( token.isSkipSpaces() || token.isNextLine()) outStream.write( ' ');
            }


            /*if (token.getToken().equals(";")) {
                outStream.write("\n");
                isNewLine = true;
            } else if (token.getToken().equals(")")) {
                if (!token.getToken().equals(";") && !token.getToken().equals(")"))
                    outStream.write(' ');
            } else if (token.getToken().equals("{")) {
                outStream.write("\n");
                isNewLine = true;
                ++tab;
            } else {
                if (token.isEnd()) break;
                token.next();
                if (!token.getToken().equals(";") && !token.getToken().equals(")"))
                    outStream.write(' ');
                continue;
            }*/
        }
        logger.info("Finish");

    }

}
