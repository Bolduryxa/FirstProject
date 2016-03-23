package com.Vladic.Bolduryxa.NewImplementation.Handlers;


import com.Vladic.Bolduryxa.NewImplementation.Exception.IHandlerException;
import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_Handler;
import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_OutputStream;

public class DeleteDoubleSpace implements I_Handler {

    @Override
    public String execute(String input) {
        if ( !input.equals( "  ")){
            throw new IHandlerException();
        }
        return " ";
    }


}
