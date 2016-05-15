package com.Vladic.Bolduryxa.NewImplementation.handlers;

/**
 * @author Vladiclav
 *
 * @since JDK 1.8
 */

public class IHandlerException extends RuntimeException {

    public IHandlerException(){
        super();
    }

    public IHandlerException(final String message){
        super(message);
    }

    public IHandlerException(final String message, final Throwable cause){
        super(message, cause);
    }

    public IHandlerException(final Throwable cause){
        super(cause);
    }
}
