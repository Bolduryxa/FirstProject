
package com.Vladic.Bolduryxa.NewImplementation.fileinputstreams;


import com.Vladic.Bolduryxa.NewImplementation.Closeable.Closeable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


/**Creates a <code>fileinputstreams</code> by
 *  opening a connection to an actual file,
 *  the file named by the path name <code>name</code>
 *  in the file system.
 *
 *  @exception FileInputStreams Caused FileNotFoundException<br>
 *              If the file does not exist, is a directory
 *              rather than a regular file, or for some
 *              other reason can not be opened for reading.
 *              Inside FileNotFoundException exception is embedded.
 */

public class FileInputStreams implements IInputStream, Closeable {
    /**
     *
     */
    private java.io.FileInputStream inputStream;


    /**
     *
     * @param filename 'filename'
     * @throws InputStreamException 'InputStreamException'
     */
    public FileInputStreams(final String filename) throws InputStreamException {
        try {
            inputStream = new java.io.FileInputStream(new File(filename));
        } catch (FileNotFoundException e) {
            throw new InputStreamException("File not found", e);
        }
    }

    /**
     *
     * @return
     */
    public char read()  {
        try {
            return (char) inputStream.read();
        } catch (IOException e) {
            throw new InputStreamException("IO error", e);
        }
    }

    /**
     *
     * @return
     */
    public boolean hasNext() {
        try {
            return inputStream.available() != 0;
        } catch (IOException e) {
            throw new InputStreamException("IO error", e);
        }
    }

    /**
     *
     */
    public void close()  {

        try {
            inputStream.close();
        } catch (IOException e) {
            throw new InputStreamException("IO error", e);
        }
    }
}
