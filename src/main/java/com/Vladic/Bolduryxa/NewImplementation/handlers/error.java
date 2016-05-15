package com.Vladic.Bolduryxa.NewImplementation.handlers;

/**
 * Created by bolduryxa on 15.05.16.
 */
public class error extends RuntimeException implements IHandler {

    public error(){
        super();
    }

    @Override
    public String execute(final String input) {
        throw this;
    }
}
