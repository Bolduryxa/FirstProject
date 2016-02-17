package com.Vladic.Bolduryxa.NewImplementation.FactoryMethod;


import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_Handler;

public class HandlerFactory extends OFactory {
    public I_Handler getInterfaceHandler(String classInterfaceHandlerName, String... classInterfaceHandlerArgv) {
        try {
            Object objectHandler = getObject(classInterfaceHandlerName, classInterfaceHandlerArgv);
            I_Handler outputHandler = (I_Handler) objectHandler;
            return outputHandler;
        } catch( ClassCastException e){
            throw new OFactoryException("The class does not implement the interface I_Handler", e);
        } catch (OFactoryException e){
            throw e;
        }
    }
}
