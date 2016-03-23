package com.Vladic.Bolduryxa.NewImplementation.tokenizer;

import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_InputStream;


/**
 *
 */
public class Tokenizer implements ITokenizer {
    @Override
    public String nextToken(I_InputStream inputStream) {

        return String.valueOf( inputStream.read());

    }


}
