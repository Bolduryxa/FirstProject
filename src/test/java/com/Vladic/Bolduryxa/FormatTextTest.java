package com.Vladic.Bolduryxa;

import com.Vladic.Bolduryxa.NewImplementation.configurationhandlers.ConfigurationHandlers;
import com.Vladic.Bolduryxa.NewImplementation.fileinputstreams.IInputStream;
import com.Vladic.Bolduryxa.NewImplementation.fileoutputstreams.IOutputStream;
import com.Vladic.Bolduryxa.NewImplementation.formatter.Formatter;
import com.Vladic.Bolduryxa.NewImplementation.stringoutputstreams.StringOutPutStreams;
import com.Vladic.Bolduryxa.NewImplementation.strnginpustream.StringInputStream;
import com.Vladic.Bolduryxa.NewImplementation.tokenaizer.Tokenizer;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;

import static junit.framework.TestCase.assertEquals;

public class FormatTextTest {

    private static Properties config;
    private static ConfigurationHandlers configTableHandlers;
    private static ConfigurationHandlers configTableNextHandlers;
    private static Formatter formatter;

    @BeforeClass
    public static void initConfiguration() throws IOException {
        config = new Properties();
        String conf = "Add = com.Vladic.Bolduryxa.NewImplementation.handlers.Add\n" +
                "DeleteDoubleSpace = com.Vladic.Bolduryxa.NewImplementation.handlers.DeleteDoubleSpace\n" +
                "Equal = com.Vladic.Bolduryxa.NewImplementation.handlers.Equal\n" +
                "LeftBrace  = com.Vladic.Bolduryxa.NewImplementation.handlers.LeftBrace\n" +
                "LeftParenthesis = com.Vladic.Bolduryxa.NewImplementation.handlers.LeftParenthesis\n" +
                "Less = com.Vladic.Bolduryxa.NewImplementation.handlers.Less\n" +
                "LessOrEqual = com.Vladic.Bolduryxa.NewImplementation.handlers.LessOrEqual\n" +
                "More = com.Vladic.Bolduryxa.NewImplementation.handlers.More\n" +
                "MoreOrEqual =com.Vladic.Bolduryxa.NewImplementation.handlers.MoreOrEqual\n" +
                "NotEqual = com.Vladic.Bolduryxa.NewImplementation.handlers.NotEqual\n" +
                "RightBrace = com.Vladic.Bolduryxa.NewImplementation.handlers.RightBrace\n" +
                "RightParenthesis = com.Vladic.Bolduryxa.NewImplementation.handlers.RightParenthesis\n" +
                "Semicolon = com.Vladic.Bolduryxa.NewImplementation.handlers.Semicolon\n" +
                "Sub = com.Vladic.Bolduryxa.NewImplementation.handlers.Sub\n" +
                "define = com.Vladic.Bolduryxa.NewImplementation.handlers.Define\n" +
                "inForHandler =com.Vladic.Bolduryxa.NewImplementation.handlers.inForHandler\n" +
                "LogicalAnd = com.Vladic.Bolduryxa.NewImplementation.handlers.LogicalAnd\n" +
                "error = com.Vladic.Bolduryxa.NewImplementation.handlers.error\n";
        config.load( new ByteArrayInputStream( conf.getBytes()));
        configTableHandlers = new ConfigurationHandlers();
        configTableNextHandlers = new ConfigurationHandlers();
        String expected = "|   Token    | inFor            |general            |\n" +
                "-------------+------------------+-------------------+\n" +
                "    {        | error            | LeftBrace         |\n" +
                "    }        | error            | RightBrace        |\n" +
                "    (        | LeftParenthesis  |LeftParenthesis    |\n" +
                "    )        | RightParenthesis |RightParenthesis   |\n" +
                "    ;        | inForHandler     | Semicolon         |\n" +
                "    !=       |  NotEqual        | NotEqual          |\n" +
                "    ==       |  Equal           | Equal             |\n" +
                "    >        |  More            | More              |\n" +
                "    <        |  Less            | Less              |\n" +
                "    >=       |  MoreOrEqual     | MoreOrEqual       |\n" +
                "    <=       |  LessOrEqual     | LessOrEqual       |\n" +
                "     ++      |  Add             | Add               |\n" +
                "     -       | Sub              | Sub               |\n" +
                "    &&       |  LogicalAnd      | LogicalAnd        |\n" +
                " | DeleteDoubleSpace|DeleteDoubleSpace             |\n" +
                "    for      |  error           | define            |\n" +
                "  define     |  define          | define            |\n";
        String expected1 = "|   Token    | inFor            |general            |\n" +
                "-------------+------------------+-------------------+\n" +
                "    {        |    error         | general           |\n" +
                "    }        |    error         | general           |\n" +
                "    (        |    inFor         | general           |\n" +
                "    )        | general          | general           |\n" +
                "    ;        | inFor            | general           |\n" +
                "    !=       |    inFor         | general           |\n" +
                "    ==       |    inFor         | general           |\n" +
                "    >        |  inFor           | general           |\n" +
                "    <        |  inFor           | general           |\n" +
                "    >=       |   inFor          | general           |\n" +
                "    <=       |  inFor           | general           |\n" +
                "    ++       |  inFor           | general           |\n" +
                "    -        | inFor            | general           |\n" +
                "    &&       |  inFor           | general           |\n" +
                " | inFor    | general                              |\n" +
                "    for      |  error           | inFor             |\n" +
                "    define   |  inFor           | general           |\n";

        configTableHandlers.load( new ByteArrayInputStream( expected.getBytes()));
        configTableNextHandlers.load(new ByteArrayInputStream(expected1.getBytes()));

        formatter = new Formatter( config,configTableHandlers,configTableNextHandlers );
    }

   /* @Test
    public void testDeleteDoubleSpace(){

        IOutputStream outputStream = new StringOutPutStreams();
        String string = "if    (    ) {  }";
        IInputStream inputStream = new StringInputStream(string);
        Tokenizer tokenizer = new Tokenizer(new StringInputStream( "\"{\", \"}\", \"(\", \"==\", \")\", \"for\", \">\", \"<\", \"!=\", \"<=\", \">=\", \"++\", \"--\", \" \""));
        formatter.execute(inputStream,outputStream,tokenizer);
        assertEquals("if ( ) {\n" +
                "    }" ,outputStream.toString());
    }*/
   @Test
   public void testRightParenthesis(){

       IOutputStream outputStream = new StringOutPutStreams();
       String string = "if()";
       IInputStream inputStream = new StringInputStream(string);
       Tokenizer tokenizer = new Tokenizer(new StringInputStream( "\"{\", \"}\", \"(\", \"==\", \")\", \"for\", \">\", \"<\", \"&&\", \"!=\", \"<=\", \">=\", \"++\", \"--\", \" \""));
       formatter.execute(inputStream,outputStream,tokenizer);
       assertEquals( "if () ",outputStream.toString() );
   }
    @Test
    public void testLeftBrace(){

        IOutputStream outputStream = new StringOutPutStreams();
        String string = "if(){}";
        IInputStream inputStream = new StringInputStream(string);
        Tokenizer tokenizer = new Tokenizer(new StringInputStream( "\"{\", \"}\", \"(\", \"==\", \")\", \"for\", \">\", \"<\", \"&&\", \"!=\", \"<=\", \">=\", \"++\", \"--\", \" \""));
        formatter.execute(inputStream,outputStream,tokenizer);
        assertEquals( "if () {\n" +
                "    }\n",outputStream.toString() );
    }
    @Test
    public void testMore(){

        IOutputStream outputStream = new StringOutPutStreams();
        String string = "if(x>1){}";
        IInputStream inputStream = new StringInputStream(string);
        Tokenizer tokenizer = new Tokenizer(new StringInputStream( "\"{\", \"}\", \"(\", \"==\", \")\", \"for\", \">\", \"<\", \"&&\", \"!=\", \"<=\", \">=\", \"++\", \"--\", \" \""));
        formatter.execute(inputStream,outputStream,tokenizer);
        assertEquals( "if (x > 1) {\n" +
                "    }\n",outputStream.toString() );
    }
    @Test
    public void testNotEqual(){

        IOutputStream outputStream = new StringOutPutStreams();
        String string = "if(x!=1){}";
        IInputStream inputStream = new StringInputStream(string);
        Tokenizer tokenizer = new Tokenizer(new StringInputStream( "\"{\", \"}\", \"(\", \"==\", \")\", \"for\", \">\", \"<\", \"&&\", \"!=\", \"<=\", \">=\", \"++\", \"--\", \" \""));
        formatter.execute(inputStream,outputStream,tokenizer);
        assertEquals( "if (x != 1) {\n" +
                "    }\n",outputStream.toString() );
    }

    @Test
    public void testLeftParenthesis(){

        IOutputStream outputStream = new StringOutPutStreams();
        String string = "if()";
        IInputStream inputStream = new StringInputStream(string);
        Tokenizer tokenizer = new Tokenizer(new StringInputStream( "\"{\", \"}\", \"(\", \"==\", \")\", \"for\", \">\", \"<\", \"&&\", \"!=\", \"<=\", \">=\", \"++\", \"--\", \" \""));
        formatter.execute(inputStream,outputStream,tokenizer);
        assertEquals( "if () ",outputStream.toString() );
    }
    @Test
    public void testLogicalAnd(){

        IOutputStream outputStream = new StringOutPutStreams();
        String string = "if(x==1&&y==1)";
        IInputStream inputStream = new StringInputStream(string);
        Tokenizer tokenizer = new Tokenizer(new StringInputStream( "\"{\", \"}\", \"(\", \"==\", \")\", \"for\", \">\", \"<\", \"&&\", \"!=\", \"<=\", \">=\", \"++\", \"--\", \" \""));
        formatter.execute(inputStream,outputStream,tokenizer);
        assertEquals( "if (x == 1 && y == 1) ",outputStream.toString() );
    }
    @Test
    public void testAdd(){

        IOutputStream outputStream = new StringOutPutStreams();
        String string = "if(x==1){for(int i=0;i<size;i++){x++;}}";
        IInputStream inputStream = new StringInputStream(string);
        Tokenizer tokenizer = new Tokenizer(new StringInputStream( "\"{\", \"}\", \"(\", \"==\", \")\", \"for\", \">\", \"<\", \"&&\", \"!=\", \"<=\", \">=\", \"++\", \"--\", \" \""));
        formatter.execute(inputStream,outputStream,tokenizer);
        assertEquals( "if (x == 1) {\n" +
                "    for (int i=0; i < size; i++ ) {\n" +
                "    x++ ;\n" +
                "}\n" +
                "}\n", outputStream.toString() );
    }
    }

