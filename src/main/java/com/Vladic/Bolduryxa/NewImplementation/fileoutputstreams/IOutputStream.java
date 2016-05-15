package com.Vladic.Bolduryxa.NewImplementation.fileoutputstreams;

import com.Vladic.Bolduryxa.NewImplementation.fileinputstreams.FileInputStreams;

/**
 * Interface for the output stream
 *
 * @see com.Vladic.Bolduryxa.NewImplementation.factorymethod.OutputStreamFactory
 * @see com.Vladic.Bolduryxa.NewImplementation.formatter.Formatter
 * @see FileInputStreams
 * @since JDK 1.8
 */
public interface IOutputStream {
    public void write(char changeChar);
    public void write(String output);
}
