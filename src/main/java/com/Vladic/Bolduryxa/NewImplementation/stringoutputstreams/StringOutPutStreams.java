package com.Vladic.Bolduryxa.NewImplementation.stringoutputstreams;

import com.Vladic.Bolduryxa.NewImplementation.fileoutputstreams.IOutputStream;

/**
 * Created by bolduryxa on 15.05.16.
 */
public class StringOutPutStreams implements IOutputStream, Cloneable {

    private  StringBuilder stringBuilder;


    public StringOutPutStreams() {
        this.stringBuilder = new StringBuilder();

    }
    @Override
    public void write(final char changeChar) {
        stringBuilder.append(changeChar);

    }

    @Override
    public void write(final String output) {
        stringBuilder.append(output);
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
