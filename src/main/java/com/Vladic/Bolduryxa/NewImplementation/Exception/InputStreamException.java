package com.Vladic.Bolduryxa.NewImplementation.Exception;

/**
 * @author Vladiclav
 *
 * @since JDK 1.8
 */

public class InputStreamException extends RuntimeException {

    public InputStreamException(){
        super();
    }

    public InputStreamException( String message){
        super( message);
    }

    public InputStreamException( String message, Throwable cause){
        super( message, cause);
    }

    public InputStreamException( Throwable cause){
        super( cause);
    }


}
