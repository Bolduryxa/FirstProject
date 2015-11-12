package com.Vladic.Bolduryxa.Stream;

//import java.io.IOException;

/**
 * Interface for the input stream
 *
 * @author Vladiclav
 * @see FileInputText
 * @see StringInputText
 * @since JDK 1.8
 */
public interface I_InputText {

    public char getChar();
    public void next() throws IO_Exception;
    public boolean isSkipSpaces();
    public boolean isNextLine();
    public boolean isEnd();
}
