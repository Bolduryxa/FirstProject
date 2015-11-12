package com.Vladic.Bolduryxa.Stream;

/**
 * Created by Vladiclav on 12.11.2015.
 */
public class TokenException extends Exception {
    public TokenException(){
        super();
    }

    public TokenException( String message){
        super( message);
    }

    public TokenException( String message, Throwable cause){
        super( message, cause);
    }

    public TokenException( Throwable cause){
        super( cause);
    }
}
