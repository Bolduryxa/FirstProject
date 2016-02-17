package com.Vladic.Bolduryxa.NewImplementation.FactoryMethod;

import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_InputStream;

public class InputStreamFactory extends OFactory{
    public I_InputStream getInterfaceInputStream(String classInterfaceInputStreamName, String... classInterfaceInputStreamArgv) {
        try {
            Object objectStream = getObject(classInterfaceInputStreamName, classInterfaceInputStreamArgv);
            I_InputStream inputStream = (I_InputStream) objectStream;
            return inputStream;
        } catch( ClassCastException e){
            throw new OFactoryException("The class does not implement the interface I_InputStream", e);
        } catch (OFactoryException e){
            throw e;
        }
    }

}
