package com.Vladic.Bolduryxa.NewImplementation.Exception;

/**
 *
 */
public class HandlerFactoryException extends RuntimeException {
    public HandlerFactoryException(){
        super();
    }

    public HandlerFactoryException(String message){
        super( message);
    }

    public HandlerFactoryException(String message, Throwable cause){
        super( message, cause);
    }

    public HandlerFactoryException(Throwable cause){
        super( cause);
    }


}
