package com.Vladic.Bolduryxa.NewImplementation.fileinputstreams;

/**
 * @author Vladiclav
 *
 * @since JDK 1.8
 */

public class InputStreamException extends RuntimeException {

    public InputStreamException(){
        super();
    }

    public InputStreamException(final String message){
        super(message);
    }

    public InputStreamException(final String message, final Throwable cause){
        super(message, cause);
    }

    public InputStreamException(final Throwable cause){
        super(cause);
    }


}
