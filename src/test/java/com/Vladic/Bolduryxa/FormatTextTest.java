package com.Vladic.Bolduryxa;

import com.Vladic.Bolduryxa.Stream.*;
import com.Vladic.Bolduryxa.Stream.I_OutputText;
import com.Vladic.Bolduryxa.Stream.I_InputText;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Vladiclav on 31.10.2015.
 */
public class FormatTextTest {

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
    }

}