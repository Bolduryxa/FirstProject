package com.Vladic.Bolduryxa.NewImplementation.factorymethod;


import com.Vladic.Bolduryxa.NewImplementation.handlers.IHandler;

/**
 *
 */
public class HandlerFactory extends OFactory<IHandler> {
    /**
     *
     * @param classHandlerName 'classHandlerName'
     * @param objectConstructorArgv 'objectConstructorArgv'
     * @return
     */
    public IHandler getObject(final String classHandlerName, final Object... objectConstructorArgv) {
        try {
            return super.getObject(classHandlerName, objectConstructorArgv);
        } catch (ClassCastException e) {
            throw new HandlerFactoryException("The class does not implement the interface Handler", e);
        } catch (OFactoryException e){
            throw new HandlerFactoryException(e);
        }
    }

   /* public IHandler getInterfaceHandler(String classInterfaceHandlerName, String... classInterfaceHandlerArgv) {
        try {
            Object objectHandler = getObject(classInterfaceHandlerName, classInterfaceHandlerArgv);
            IHandler outputHandler = (IHandler) objectHandler;
            return outputHandler;
        } catch( ClassCastException e){
            throw new OFactoryException("The class does not implement the interface IHandler", e);
        } catch (OFactoryException e){
            throw e;
        }
    }*/
}
