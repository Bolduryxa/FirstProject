package com.Vladic.Bolduryxa.NewImplementation.factorymethod;


public class OFactoryException extends RuntimeException {

    public OFactoryException(){
        super();
    }

    public OFactoryException(final String message){
        super(message);
    }

    public OFactoryException(final String message, final Throwable cause){
        super(message, cause);
    }

    public OFactoryException(final Throwable cause){
        super(cause);
    }
}
