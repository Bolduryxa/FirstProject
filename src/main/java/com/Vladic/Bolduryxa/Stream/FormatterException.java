package com.Vladic.Bolduryxa.Stream;

/**
 * Created by Vladiclav on 12.11.2015.
 */
public class FormatterException extends Exception {
    public FormatterException(){
        super();
    }

    public FormatterException( String message){
        super( message);
    }

    public FormatterException( String message, Throwable cause){
        super( message, cause);
    }

    public FormatterException( Throwable cause){
        super( cause);
    }

}
