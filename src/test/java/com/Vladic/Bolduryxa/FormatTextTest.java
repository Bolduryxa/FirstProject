package com.Vladic.Bolduryxa;

import com.Vladic.Bolduryxa.NewImplementation.Formatter.Formatter;
import com.Vladic.Bolduryxa.NewImplementation.Interfaces.I_InputStream;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

public class FormatTextTest {

    /*private static Properties config;
    private static Formatter formatter;

    @BeforeClass
    public static void initConfiguration(){
        config = new Properties();
        config.setProperty("InterfaceInputStream", "com.Vladic.Bolduryxa.StringInputStreamStub");
        config.setProperty("InterfaceInputStream.countArguments", "1");
        config.setProperty("InterfaceInputStream.argument1", "");
        config.setProperty("InterfaceOutputStream", "com.Vladic.Bolduryxa.StringOutputStreamStub");
        formatter = new Formatter( config);
    }

    @Test
    public void testDeleteDoubleSpace(){
        config.setProperty("InterfaceInputStream.argument1", "if  (  ){  }");
        config.setProperty("InterfaceHandlersCount", "1");
        config.setProperty("InterfaceHandler1", "com.Vladic.Bolduryxa.NewImplementation.Handlers.DeleteDoubleSpace");
        formatter.initProperties( config);
        formatter.execute();
        assertEquals( StringOutputStreamStub.result, "if ( ){ }");
    }
    @Test
    public void testLeftParenthesis() {
        config.setProperty("InterfaceInputStream.argument1", "if(){ }");
        config.setProperty("InterfaceHandlersCount", "2");
        config.setProperty("InterfaceHandler2", "com.Vladic.Bolduryxa.NewImplementation.Handlers.LeftParenthesis");
        formatter.initProperties( config);
        formatter.execute();
        assertEquals( StringOutputStreamStub.result, "if (){ }");
    }*/

    }


//тесты для консоли
    /*
    @Test
    public void testNewlineAfterSemicolon() throws FormatterException {
        I_InputText in = new StringInputText( "public static int main( String argv[]){System.out.println();return 0;}");
        I_OutputText out = new StringOutputText();
        FormatText formater = new FormatText( in, out);
        formater.format();

        assertEquals( "public static int main( String argv[]) {\n    System.out.println() ;\n    return 0;\n}\n", out.toString());
    }
   @Test
    public void testFormattingIf () throws FormatterException {
        I_InputText in = new StringInputText( "if(){}");
        I_OutputText out = new StringOutputText();
        FormatText formater = new FormatText( in, out);
        formater.format();

        assertEquals( "if () {\n}\n", out.toString());
    }
    @Test
    public void testFormattingIfelse () throws FormatterException {
        I_InputText in = new StringInputText( "if(){}else{}");
        I_OutputText out = new StringOutputText();
        FormatText formater = new FormatText( in, out);
        formater.format();

        assertEquals( "if () {\n}\nelse {\n}\n", out.toString());
    }
    public void testNewLineAfterOpenParenthesis() throws FormatterException {
        I_InputText in = new StringInputText( "{");
        I_OutputText out = new StringOutputText();
        FormatText formater = new FormatText( in, out);
        formater.format();

        assertEquals( " {\n", out.toString());
    }*/

