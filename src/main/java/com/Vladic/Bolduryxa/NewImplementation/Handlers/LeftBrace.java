package com.Vladic.Bolduryxa.NewImplementation.Handlers;


import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_Handler;
import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_OutputStream;

public class LeftBrace implements I_Handler {

   private String space ="    ";


    @Override
    public String execute(String input) {


        return " {\n"+space;
    }
}
