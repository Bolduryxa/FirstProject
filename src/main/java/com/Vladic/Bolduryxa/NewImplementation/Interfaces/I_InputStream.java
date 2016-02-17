package com.Vladic.Bolduryxa.NewImplementation.Interfaces;

import com.Vladic.Bolduryxa.NewImplementation.Exception.InputStreamException;

/**
 * Interface for the input stream
 *
 * @author Vladiclav
 * @see com.Vladic.Bolduryxa.NewImplementation.FactoryMethod.InputStreamFactory
 * @see com.Vladic.Bolduryxa.NewImplementation.Formatter.Formatter
 * @see com.Vladic.Bolduryxa.NewImplementation.Streams.FileInputStreams
 * @since JDK 1.8
 */
public interface I_InputStream {
    public char read();
    public boolean hasNext();
    public void close();
}
