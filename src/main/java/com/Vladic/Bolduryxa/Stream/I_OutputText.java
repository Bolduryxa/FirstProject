package com.Vladic.Bolduryxa.Stream;

/**
 * Created by Vladiclav on 31.10.2015.
 */
/**
 * Interface for the output stream
 *
 * @see StringInputText
 * @see SystemOutputText
 * @since JDK 1.8
 */
public interface I_OutputText {

    public void write( char buf);
    public void write( String buf);
    public void close();
}
