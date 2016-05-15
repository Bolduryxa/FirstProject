package com.Vladic.Bolduryxa.NewImplementation.strnginpustream;

import com.Vladic.Bolduryxa.NewImplementation.fileinputstreams.IInputStream;

/**
 * Created by bolduryxa on 15.05.16.
 */
public class StringInputStream implements IInputStream, Cloneable {

    private final String inputStream;
    private int pos;

    public StringInputStream(final String string) {
        inputStream = string;
        pos = 0;
    }
    @Override
    public char read() {
        return inputStream.charAt(pos++);
    }

    @Override
    public boolean hasNext() {
        return pos < inputStream.length();
    }
    public void close() {
        pos = 0;
    }
}
