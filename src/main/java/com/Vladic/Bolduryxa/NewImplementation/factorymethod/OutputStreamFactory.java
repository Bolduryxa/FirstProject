package com.Vladic.Bolduryxa.NewImplementation.factorymethod;


import com.Vladic.Bolduryxa.NewImplementation.fileoutputstreams.IOutputStream;

/**
 *
 */
public class OutputStreamFactory extends OFactory<IOutputStream> {
    /**
     *
     * @param classInterfaceOutputStreamName 'classInterfaceOutputStreamName'
     * @param classInterfaceOutputStreamArgv 'classInterfaceOutputStreamArgv'
     * @return
     */
    public IOutputStream getInterfaceOutputStream(final String classInterfaceOutputStreamName, final Object... classInterfaceOutputStreamArgv) {
        try {
          /*Object objectStream = getObject(classInterfaceOutputStreamName, classInterfaceOutputStreamArgv);
          IOutputStream outputStream = (IOutputStream) objectStream;
            return outputStream;*/
            return super.getObject(classInterfaceOutputStreamName, classInterfaceOutputStreamArgv);

        } catch (ClassCastException e){
            throw new OFactoryException("The class does not implement the interface IOutputStream", e);
        } catch (OFactoryException e){
            throw e;
        }
    }
}
