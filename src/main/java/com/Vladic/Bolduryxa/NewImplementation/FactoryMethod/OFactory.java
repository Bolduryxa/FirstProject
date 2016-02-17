package com.Vladic.Bolduryxa.NewImplementation.FactoryMethod;


import java.lang.reflect.InvocationTargetException;

public class OFactory {


    public Object getObject(String objectName,String... objectConstructorTypeStringargv) {

        try {
            Class classStream = Class.forName(objectName);
            Class[] argvClass = new Class[objectConstructorTypeStringargv.length];
            for (int i = 0; i < objectConstructorTypeStringargv.length; ++i)
                argvClass[i] = String.class;
            try {
                return classStream.getConstructor(argvClass).newInstance(objectConstructorTypeStringargv);
            } catch (InstantiationException e) {
                throw new OFactoryException("Failed to create object  "+objectName+" This class is an abstract class, interface, array class" +
                        ", primitive type, or void , or the class does not have a constructor with no arguments, or you can not create an instance of the class for some other reason.", e);
            } catch (IllegalAccessException e) {
                throw new OFactoryException("Failed to create object " + objectName + " Class or a no-argument constructor is not available.",e);
            } catch (InvocationTargetException e) {
                throw new OFactoryException(" Failed to create object " + objectName +" The main constructor throws an exception.",e);
            } catch (NoSuchMethodException e) {
                throw new OFactoryException("The constructor is not found",e);
            }
        } catch (ClassNotFoundException e) {
            throw new OFactoryException("Class " + objectName + " not found",e);
        }


    }


}
