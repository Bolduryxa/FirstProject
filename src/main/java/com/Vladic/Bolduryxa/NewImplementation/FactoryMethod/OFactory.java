package com.Vladic.Bolduryxa.NewImplementation.FactoryMethod;


import java.lang.reflect.InvocationTargetException;

public class OFactory<T> {

    public T getObject(String objectName, Object... objectConstructorArgv) {
        try {
            Class classIStream = Class.forName(objectName);
            try {
                int countArgv = 0;
                if( objectConstructorArgv != null){
                    countArgv = objectConstructorArgv.length;
                }
                Class[] argvClass = new Class[ countArgv];
                for (int i = 0; i < countArgv; ++i) {
                    argvClass[i] = objectConstructorArgv[i].getClass();
                }
                return (T) classIStream.getConstructor(argvClass).newInstance(objectConstructorArgv);
            } catch (NoSuchMethodException e) {
                throw new OFactoryException("The constructor is not found", e);
            } catch (IllegalAccessException e) {
                throw new OFactoryException("Failed to create object \"" + objectName + "\" Perhaps a class or a no-argument constructor is not available.", e);
            } catch (InstantiationException e) {
                throw new OFactoryException("Failed to create object \"" + objectName + "\" Perhaps this class is an abstract class, interface, array class" +
                        ", primitive type, or void; or the class does not have a constructor with no arguments; or you can not create an instance of the class for some other reason.", e);
            } catch (InvocationTargetException e) {
                throw new OFactoryException("Failed to create object \"" + objectName + "\" The main constructor throws an exception.", e);
            }
        } catch (NullPointerException | ClassNotFoundException e) {
            throw new OFactoryException( "Class \"" + objectName + "\" not found", e);
        }
    }

   /* public Object getObject(String objectName,String... objectConstructorTypeStringargv) {

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
*/

}
