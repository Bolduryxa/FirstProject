package com.Vladic.Bolduryxa.Stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Vladiclav
 */

public class FileInputText implements I_InputText {
    /**Creates a <code>FileInputText</code> by
    *  opening a connection to an actual file,
            *  the file named by the path name <code>name</code>
            *  in the file system.
            *
            *  @param name the file name
    *  @exception IO_Exception Caused FileNotFoundException<br>
    *              If the file does not exist, is a directory
    *              rather than a regular file, or for some
    *              other reason can not be opened for reading.
    *              Inside FileNotFoundException exception is embedded.
    */

    private FileInputStream fileInputStream;
    private int character;

    public FileInputText( File file) throws IO_Exception {
        try {
            this.fileInputStream = new FileInputStream( file);
        }
           catch (FileNotFoundException e) {
             
            throw new IO_Exception( "File not found", e);
        }
        this.character = 0;
    }

    public char getChar() {
        return (char) character;
    }

    public void next() throws IO_Exception{
        try {
            character = fileInputStream.read();
        } catch (IOException e) {

            throw new IO_Exception( e);
        }
    }

    public boolean isSkipSpaces() {
        return false;
    }

    public boolean isNextLine() {
        return false;
    }

    @Override
    public boolean isEnd() {
        return (character == -1);
    }
}
