package com.Vladic.Bolduryxa.NewImplementation.formatter;


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
