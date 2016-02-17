package com.Vladic.Bolduryxa.NewImplementation.Formatter;


public class FormatterException extends RuntimeException{
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
