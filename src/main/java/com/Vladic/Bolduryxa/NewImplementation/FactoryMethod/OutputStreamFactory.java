package com.Vladic.Bolduryxa.NewImplementation.FactoryMethod;


import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_OutputStream;

public class OutputStreamFactory extends OFactory {
    public I_OutputStream getInterfaceOutputStream(String classInterfaceOutputStreamName, String... classInterfaceOutputStreamArgv) {
        try {
            Object objectStream = getObject(classInterfaceOutputStreamName, classInterfaceOutputStreamArgv);
            I_OutputStream outputStream = (I_OutputStream) objectStream;
            return outputStream;
        } catch( ClassCastException e){
            throw new OFactoryException("The class does not implement the interface I_OutputStream", e);
        } catch (OFactoryException e){
            throw e;
        }
    }
}
