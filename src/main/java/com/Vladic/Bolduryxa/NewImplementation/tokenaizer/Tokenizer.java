package com.Vladic.Bolduryxa.NewImplementation.tokenaizer;

import com.Vladic.Bolduryxa.NewImplementation.fileinputstreams.IInputStream;
import com.Vladic.Bolduryxa.NewImplementation.ishandler.IsHandler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by bolduryxa on 14.05.16.
 */
public class Tokenizer {
    private StringBuilder  copyStringToken;
    private Set<String> tokens;

    /**
     *
     */

  public Tokenizer(IInputStream inputStream) {


      copyStringToken = new StringBuilder();
      copyStringToken.delete(0, copyStringToken.length());
      tokens = new HashSet<>();
        load(inputStream);
  }

    private void load(IInputStream inputStream) {
        StringBuilder token = new StringBuilder();
        char character;
        char separator = ' ';
        while (inputStream.hasNext()) {
            token.delete(0, token.length());
            while (inputStream.hasNext() && (separator = inputStream.read()) == ' ') ;
            while (inputStream.hasNext() && (character = inputStream.read()) != separator) {
                token.append(character);
            }
            tokens.add(token.toString());
            while (inputStream.hasNext() && inputStream.read() == ',') ;
        }
    }

    public String searchHandlerForTheToken(final String  token, final IsHandler isHandler) {

        copyStringToken.append(token);
        isHandler.setIsHandler(true);
        if (tokens.contains(copyStringToken.toString())) {
            String temp = copyStringToken.toString();
            copyStringToken.delete(0, copyStringToken.length());
            return temp;
        } else {
            Iterator<String> iterator = tokens.iterator();
            boolean start = false;
            while (iterator.hasNext() && !start){
                String temp = iterator.next();
                if (temp.startsWith(copyStringToken.toString())) {
                    start = true;
                }
            }
            isHandler.setIsHandler( !start);
            if( !start){
                String temp = copyStringToken.substring(0, 1);
                copyStringToken.delete(0, 1);
                return temp;
            }
            return null;
        }

    }

    public String getToken(){
        String temp = copyStringToken.substring(0, 1);
        copyStringToken.delete(0, 1);
        return temp;
    }

    public boolean hasNext(){
        return copyStringToken.length() > 0;
    }

}
