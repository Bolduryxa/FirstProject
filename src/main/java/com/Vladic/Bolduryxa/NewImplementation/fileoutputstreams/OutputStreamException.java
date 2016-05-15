package com.Vladic.Bolduryxa.NewImplementation.fileoutputstreams;
/**
 * @author Vladiclav
 *
 * @since JDK 1.8
 */

public class OutputStreamException extends RuntimeException {

    public OutputStreamException(){
        super();
    }

    public OutputStreamException( String message){
        super( message);
    }

    public OutputStreamException( String message, Throwable cause){
        super( message, cause);
    }

    public OutputStreamException( Throwable cause){
        super( cause);
    }
}
