package com.Vladic.Bolduryxa.NewImplementation.fileinputstreams;

/**
 * Interface for the input stream
 *
 * @author Vladiclav
 * @see com.Vladic.Bolduryxa.NewImplementation.factorymethod.InputStreamFactory
 * @see com.Vladic.Bolduryxa.NewImplementation.formatter.Formatter
 * @see FileInputStreams
 * @since JDK 1.8
 */
public interface IInputStream {
    /**
     *
     * @return
     */
    public char read();
    public boolean hasNext();
}
