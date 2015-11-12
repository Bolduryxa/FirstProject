package com.Vladic.Bolduryxa.Stream;

/**
 * Created by Vladiclav on 31.10.2015.
 */
public class SystemOutputText implements I_OutputText {


    public SystemOutputText() {
    }

    @Override
    public void write(char buf) {
        System.out.print( buf);
    }

    public void write(String buf) {
        System.out.print( buf);
    }

    @Override
    public void close() {}
}
