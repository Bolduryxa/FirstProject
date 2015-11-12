package com.Vladic.Bolduryxa.Stream;

/**
 * Created by Vladiclav on 31.10.2015.
 */
public class StringInputText implements I_InputText {

    private String buf;
    private int index;
    private boolean isSkipSpaces;
    private boolean isNextLine;
    private boolean isEnd;

    public StringInputText( String str){
        buf = str;
        index = 0;
        isSkipSpaces = true;
        isNextLine = true;
        isEnd = false;
    }

    public char getChar() {
        if( isEnd) return 0;
        if(  index < 0 ||   buf.length() < index) return 0;
        return buf.charAt(index);
    }

    public void next() {
        if( isEnd) return;
        ++index;
        if( buf.length() == index){
            isEnd = true;
            return;
        }
        isSkipSpaces = false;
        isNextLine = false;
        if( buf.charAt( index) == ' ') isSkipSpaces = true;
        if( buf.charAt( index) == '\n') isNextLine = true;
        while( buf.charAt( index) == ' ' || buf.charAt( index) == '\n'){
            if( buf.charAt( index) == ' ') isSkipSpaces = true;
            if( buf.charAt( index) == '\n') isNextLine = true;
            ++index;
            if( buf.length() == index){
                isEnd = true;
                return;
            }
        }
    }

    @Override
    public boolean isSkipSpaces() {
        return isSkipSpaces;
    }

    @Override
    public boolean isNextLine() {
        return isNextLine;
    }

    @Override
    public boolean isEnd() {
        return isEnd;
    }
}
