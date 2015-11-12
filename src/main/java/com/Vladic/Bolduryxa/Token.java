package com.Vladic.Bolduryxa;

import com.Vladic.Bolduryxa.Stream.IO_Exception;
import com.Vladic.Bolduryxa.Stream.I_InputText;

import java.util.ArrayList;

/**
 * Created by Vladiclav on 02.11.2015.
 */
public class Token {

    private I_InputText inStream;
    private StringBuilder buffer1;
    private StringBuilder buffer2;
    private ArrayList<String> tokenList;

    public Token( I_InputText inStream){
        this.inStream = inStream;
        buffer1 = new StringBuilder();
        buffer2 = new StringBuilder();
        tokenList = new ArrayList<>();
    }

    public boolean checkToken(){
        int index;
        for( int i=0; i< tokenList.size(); ++i)
            if( (index = buffer1.indexOf( tokenList.get( i))) != -1){
                if( index == 0) return true;
                buffer2.append( buffer1.substring( index));
                buffer1.delete( index, buffer1.length());
                return true;
            }
        return false;
    }

    public void next(){
        buffer1.delete( 0, buffer1.length());
        if( buffer2.length() > 0){
            buffer1.append( buffer2.toString());
            buffer2.delete( 0, buffer2.length());
            return;
        }
        buffer1.append( inStream.getChar());
        try {
            inStream.next();
        } catch (IO_Exception e) {
            e.printStackTrace();
        }
        if( checkToken()) return;
        while( !inStream.isEnd() && !inStream.isSkipSpaces() && !inStream.isNextLine()) {
            buffer1.append(inStream.getChar());
            try {
                inStream.next();
            } catch (IO_Exception e) {
                e.printStackTrace();
            }
            if( checkToken()) return;
        }
    }

    public void add( String str){
        tokenList.add( str);
    }

    public String getToken(){
        return buffer1.toString();
    }

    public boolean isEnd(){
        return inStream.isEnd();
    }

    public boolean isSkipSpaces(){ return inStream.isSkipSpaces(); }
    public boolean isNextLine(){ return inStream.isNextLine(); }
}
