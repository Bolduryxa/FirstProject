package com.Vladic.Bolduryxa.NewImplementation.FactoryMethod;


public class OFactoryException extends RuntimeException {

    public OFactoryException(){
        super();
    }

    public OFactoryException(String message){
        super( message);
    }

    public OFactoryException(String message, Throwable cause){
        super( message, cause);
    }

    public OFactoryException(Throwable cause){
        super( cause);
    }
}
