package com.Vladic.Bolduryxa.NewImplementation.Handlers;


import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_Handler;
import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_OutputStream;
import com.sun.org.apache.xpath.internal.operations.String;

public class LeftParenthesis implements I_Handler {

    @Override
    public java.lang.String execute(java.lang.String input) {


        return " ( ";
    }


}
