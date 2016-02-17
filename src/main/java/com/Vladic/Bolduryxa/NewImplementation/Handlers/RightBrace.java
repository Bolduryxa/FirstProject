package com.Vladic.Bolduryxa.NewImplementation.Handlers;

import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_Handler;
import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_OutputStream;


public class RightBrace implements I_Handler {

    private Boolean isPreviousSpace;{
        isPreviousSpace = false;
    }



    @Override
    public boolean execute(char inputChar, I_OutputStream outputStream) {

        int variable;
        try {
            variable =1/(inputChar-'}');
            try {
                variable =1/(inputChar-' ');
                isPreviousSpace = false;
            } catch (ArithmeticException e) {
                isPreviousSpace = true;
                return false;
            }

        } catch (ArithmeticException e) {
            try{
                variable = 1/isPreviousSpace.compareTo( new Boolean( "false"));
                outputStream.write( '}');
            }catch( ArithmeticException ex){
                outputStream.write( '}');
                outputStream.write( ' ');

            }
            isPreviousSpace = false;
            return true;
        }
        return false;
    }
}
