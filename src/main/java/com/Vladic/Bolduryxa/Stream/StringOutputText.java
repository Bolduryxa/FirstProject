package com.Vladic.Bolduryxa.Stream;

/**
 * Created by Vladiclav on 31.10.2015.
 */

public class StringOutputText implements I_OutputText {


    private StringBuilder str;
    public StringOutputText() {
        str = new StringBuilder();
    }

    public void write(char buf) {
        str.append( buf);
    }

    public void write(String buf) {
        str.append(buf);
    }

    @Override
    public void close() {}

    @Override
    public String toString(){
        return str.toString();
    }
}
