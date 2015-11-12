package com.Vladic.Bolduryxa.Stream;

/**
 * Created by user on 09.11.2015.
 */
public class IO_Exception extends Exception{

    public IO_Exception(){
        super();
    }

    public IO_Exception( String message){
        super( message);
    }

    public IO_Exception( String message, Throwable cause){
        super( message, cause);
    }

    public IO_Exception( Throwable cause){
        super( cause);
    }

}
