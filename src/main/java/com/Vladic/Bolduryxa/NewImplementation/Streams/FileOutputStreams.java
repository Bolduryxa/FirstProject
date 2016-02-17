package com.Vladic.Bolduryxa.NewImplementation.Streams;


import com.Vladic.Bolduryxa.NewImplementation.Exception.OutputStreamException;
import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_OutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileOutputStreams implements I_OutputStream {

    private java.io.FileOutputStream outputStream;

    public FileOutputStreams( String filename){
        try {
            outputStream = new java.io.FileOutputStream( new File( filename));
        } catch (FileNotFoundException e) {
            throw new OutputStreamException( "File not found", e);
        }



    }

    public void write(char changeChar) {
        try {
            outputStream.write( changeChar);
        } catch (IOException e) {
            throw new OutputStreamException( "Write error", e);
        }
    }

    public void close() {
        try {
            outputStream.close();
        } catch (IOException e) {
            throw new OutputStreamException( "Close exception", e);
        }
    }
}
