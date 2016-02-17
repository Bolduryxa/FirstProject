package com.Vladic.Bolduryxa.NewImplementation.Interfaces;

import com.Vladic.Bolduryxa.NewImplementation.Exception.OutputStreamException;

/**
 * Interface for the output stream
 *
 * @see com.Vladic.Bolduryxa.NewImplementation.FactoryMethod.OutputStreamFactory
 * @see com.Vladic.Bolduryxa.NewImplementation.Formatter.Formatter
 * @see com.Vladic.Bolduryxa.NewImplementation.Streams.FileInputStreams
 * @since JDK 1.8
 */
public interface I_OutputStream {
    public void write(char changeChar);
    public void close();
}
