package com.Vladic.Bolduryxa.NewImplementation.Handlers;

import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_Handler;
import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_OutputStream;

public class TransferLine implements I_Handler {

    private Boolean isPreviousSpace;

    {
        isPreviousSpace = false;
    }

    private Integer isCountBrace;

    {
        isCountBrace = 0;
    }

    private Integer sizeSpace;

    {
        sizeSpace = 4;
    }

    @Override
    public boolean execute(char inputChar, I_OutputStream outputStream) {

        int variable;

        try{
            variable =1/(inputChar-'{');
            try{
                variable =1/(inputChar-'}');
            } catch (ArithmeticException e) {
               isCountBrace--;
                outputStream.write('\n');
                for (int i=0;i<sizeSpace*isCountBrace;i++) {
                    outputStream.write(' ');
                }
                outputStream.write('}');
                return true;
            }
        } catch (ArithmeticException e) {
            isCountBrace++;
            outputStream.write('{');
            outputStream.write('\n');
            for (int i=0;i<sizeSpace*isCountBrace;i++) {
                outputStream.write(' ');
            }
            return true;
        }
        return false;


        }
}