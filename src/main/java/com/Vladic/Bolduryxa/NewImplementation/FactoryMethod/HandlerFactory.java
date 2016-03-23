package com.Vladic.Bolduryxa.NewImplementation.FactoryMethod;


import com.Vladic.Bolduryxa.NewImplementation.Exception.HandlerFactoryException;
import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_Handler;

public class HandlerFactory extends OFactory<I_Handler> {
    public I_Handler getObject(String classHandlerName, Object... objectConstructorArgv) {
        try {
            return super.getObject(classHandlerName, objectConstructorArgv);
        } catch( ClassCastException e){
            throw new HandlerFactoryException( "The class does not implement the interface Handler", e);
        } catch (OFactoryException e){
            throw new HandlerFactoryException( e);
        }
    }

   /* public I_Handler getInterfaceHandler(String classInterfaceHandlerName, String... classInterfaceHandlerArgv) {
        try {
            Object objectHandler = getObject(classInterfaceHandlerName, classInterfaceHandlerArgv);
            I_Handler outputHandler = (I_Handler) objectHandler;
            return outputHandler;
        } catch( ClassCastException e){
            throw new OFactoryException("The class does not implement the interface I_Handler", e);
        } catch (OFactoryException e){
            throw e;
        }
    }*/
}
