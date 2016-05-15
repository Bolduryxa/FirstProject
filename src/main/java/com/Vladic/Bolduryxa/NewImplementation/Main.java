package com.Vladic.Bolduryxa.NewImplementation;

import com.Vladic.Bolduryxa.NewImplementation.Closeable.Closeable;
import com.Vladic.Bolduryxa.NewImplementation.configurationhandlers.ConfigurationHandlers;
import com.Vladic.Bolduryxa.NewImplementation.facadlogger.Facad;
import com.Vladic.Bolduryxa.NewImplementation.facadlogger.IFacad;
import com.Vladic.Bolduryxa.NewImplementation.fileinputstreams.FileInputStreams;
import com.Vladic.Bolduryxa.NewImplementation.fileinputstreams.IInputStream;
import com.Vladic.Bolduryxa.NewImplementation.fileoutputstreams.FileOutputStreams;
import com.Vladic.Bolduryxa.NewImplementation.fileoutputstreams.IOutputStream;
import com.Vladic.Bolduryxa.NewImplementation.formatter.Formatter;
import com.Vladic.Bolduryxa.NewImplementation.formatter.FormatterException;
import com.Vladic.Bolduryxa.NewImplementation.tokenaizer.Tokenizer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    private  static final IFacad logger = Facad.getLogger(Main.class);

    Formatter formatter;
    private Tokenizer tokenizer;
    private void loadProperties(final Properties properties, final String  filename) {
        InputStream inputStream = null;
        try {
            inputStream = Main.class.getClassLoader().getResourceAsStream(filename);

            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();


                logger.error(String.format("File not found '%s'", filename));
                System.exit(1);
            }
        }
    }

    /**
     *
     * @param argv 'argv'
     */
    public Main(final  String[] argv) {

        Properties configHandlers = new Properties();

        InputStream configurationStateFileName = Main.class.getClassLoader().getResourceAsStream("ConfigState.table");
        InputStream configurationNextState = Main.class.getClassLoader().getResourceAsStream("stateforhandlers.table");

        String handlersFileName = "handlers.properties";
        IInputStream handlersForTokens = new FileInputStreams("handlersForTokens.txt");
        ConfigurationHandlers configTableHandlers = new ConfigurationHandlers();
        ConfigurationHandlers configTableNextHandlers = new ConfigurationHandlers();
        configTableHandlers.load(configurationStateFileName);
        configTableNextHandlers.load(configurationNextState);
        loadProperties(configHandlers, handlersFileName);
        tokenizer = new Tokenizer(handlersForTokens);
        try {
            formatter = new Formatter(configHandlers, configTableHandlers, configTableNextHandlers);

        } catch (FormatterException e){
            logger.error(e.getMessage());
            System.exit(2);

        }

    }

    public void start() {
        try {
            IInputStream inputStream = new FileInputStreams("input.txt");
            IOutputStream outputStream = new FileOutputStreams("output.txt");
            formatter.execute(inputStream, outputStream, tokenizer);
            ((Closeable) inputStream).close();
            ((Closeable) outputStream).close();
        } catch (  Exception e){
            Throwable cause = e;
            while (cause != null){
                logger.error(cause.getMessage());
                cause = cause.getCause();
            }
            System.exit(2);
        }

    }

    /**
     *
     * @param argv 'argv'
     */
    public static void main(final String[] argv) {
    new Main(argv).start();
}
}

