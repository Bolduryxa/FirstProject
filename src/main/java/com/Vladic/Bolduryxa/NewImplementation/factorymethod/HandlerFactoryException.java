package com.Vladic.Bolduryxa.NewImplementation.factorymethod;

/**
 *
 */
public class HandlerFactoryException extends RuntimeException {
    public HandlerFactoryException(){
        super();
    }

    public HandlerFactoryException(final String message){
        super(message);
    }

    public HandlerFactoryException(final String message, final Throwable cause){
        super(message, cause);
    }

    public HandlerFactoryException(final Throwable cause){
        super(cause);
    }


}
