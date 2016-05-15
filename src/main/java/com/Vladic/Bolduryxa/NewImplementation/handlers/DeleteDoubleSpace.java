package com.Vladic.Bolduryxa.NewImplementation.handlers;


/**
 *
 */
public class DeleteDoubleSpace implements IHandler {

    @Override
    public String execute(final String input) {
        if (!input.equals(" ")) {
            throw new IHandlerException();
        }
        return "";
    }


}
