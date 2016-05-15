package com.Vladic.Bolduryxa.NewImplementation.factorymethod;

import com.Vladic.Bolduryxa.NewImplementation.fileinputstreams.IInputStream;

/**
 *
 */
public class InputStreamFactory extends OFactory<IInputStream>{
    /**
     *
     * @param classInterfaceInputStreamName 'classInterfaceInputStreamName'
     * @param classInterfaceInputStreamArgv 'classInterfaceInputStreamArgv'
     * @return
     */
    public IInputStream getInterfaceInputStream(final String classInterfaceInputStreamName, final Object... classInterfaceInputStreamArgv) {
        try {
           // Object objectStream = getObject(classInterfaceInputStreamName, classInterfaceInputStreamArgv);
            //IInputStream inputStream = (IInputStream) objectStream;
           // return inputStream;
            return super.getObject(classInterfaceInputStreamName, classInterfaceInputStreamArgv);
        } catch (ClassCastException e){
            throw new OFactoryException("The class does not implement the interface IInputStream", e);
        } catch (OFactoryException e){
            throw e;
        }
    }

}
