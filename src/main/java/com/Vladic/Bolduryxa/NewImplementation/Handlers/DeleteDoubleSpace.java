package com.Vladic.Bolduryxa.NewImplementation.Handlers;


import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_Handler;
import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_OutputStream;

public class DeleteDoubleSpace implements I_Handler {

    private int countSpace;

    public DeleteDoubleSpace()
    {
        countSpace = 0;
    }

    public boolean execute(char inputChar, I_OutputStream outputStream) {
        int variable;
        try {
             variable = 1/(inputChar - ' ');
            countSpace = 0;
        } catch ( ArithmeticException e){
            countSpace++;
            try {
                variable  = 1/(countSpace-2);
            } catch ( ArithmeticException ex) {
                countSpace--;
                return true;
            }
        }
        return false;
    }
}
