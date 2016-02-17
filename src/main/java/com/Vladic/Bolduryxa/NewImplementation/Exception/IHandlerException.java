package com.Vladic.Bolduryxa.NewImplementation.Exception;

/**
 * @author Vladiclav
 *
 * @since JDK 1.8
 */

public class IHandlerException extends RuntimeException {

    public IHandlerException(){
        super();
    }

    public IHandlerException(String message){
        super( message);
    }

    public IHandlerException(String message, Throwable cause){
        super( message, cause);
    }

    public IHandlerException(Throwable cause){
        super( cause);
    }
}
