package com.Vladic.Bolduryxa;

import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_InputStream;

public class StringInputStreamStub implements I_InputStream {

    private final String buffer;
    private int pos;

    public StringInputStreamStub(String buffer) {
        this.buffer = buffer;
        this.pos = 0;
    }

    @Override
    public char read() {
        pos++;
        return buffer.charAt( pos - 1);
    }

    @Override
    public boolean hasNext() {
        return buffer.length() > pos;
    }

    @Override
    public void close() {
        pos = 0;
    }
}
