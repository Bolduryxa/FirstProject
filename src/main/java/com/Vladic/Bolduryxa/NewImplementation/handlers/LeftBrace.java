package com.Vladic.Bolduryxa.NewImplementation.handlers;


/**
 *
 */
public class LeftBrace implements IHandler {

   private String space = "    ";


    @Override
    public String execute(final String input) {


        return "{\n" + space;
    }
}
