package com.Vladic.Bolduryxa.NewImplementation.fileoutputstreams;



import com.Vladic.Bolduryxa.NewImplementation.Closeable.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 */
public class FileOutputStreams implements IOutputStream, Closeable {
    /**
     *
     */
    private java.io.FileOutputStream outputStream;

    /**
     *
     * @param filename 'filename'
     */
    public FileOutputStreams(final String filename){
        try {
            outputStream = new java.io.FileOutputStream(new File(filename));
        } catch (FileNotFoundException e) {
            throw new OutputStreamException("File not found", e);
        }



    }

    /**
     *
     * @param changeChar 'changeChar'
     */
    public void write(final char changeChar) {
        try {
            outputStream.write(changeChar);
        } catch (IOException e) {
            throw new OutputStreamException("Write error", e);
        }
    }

    /**
     *
     * @param output 'output'
     */
    public void write(final String output) {
        try {

            outputStream.write(output.getBytes());
        } catch (IOException e) {
            throw new OutputStreamException("Write error", e);
        }
    }

    /**
     *
     */
    public void close() {
        try {
            outputStream.close();
        } catch (IOException e) {
            throw new OutputStreamException("Close exception", e);
        }
    }
}
