package com.Vladic.Bolduryxa;


import com.Vladic.Bolduryxa.Stream.*;
import com.Vladic.Bolduryxa.Stream.I_OutputText;
import com.Vladic.Bolduryxa.Stream.I_InputText;
import com.Vladic.Bolduryxa.Stream.FormatterException;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
     public static void main(String[] args){

         Scanner sc = new Scanner( System.in);
         int a=0;
         do {
             System.out.println("Format file or string? (1/2)");
             try{
                 a = sc.nextInt();
             }catch ( InputMismatchException e){
                sc.nextLine();
             }
         }while( a != 1 && a != 2);
         I_InputText stream = null;
         if( a == 1){
             try {
                 stream = new FileInputText( new File( ""));
             } catch (IO_Exception e) {
                 e.printStackTrace();
             }
         }
         else{
             System.out.println( "Enter a string (enter to complete ctrl-Z or ctrl-D):");
             BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
             StringBuilder str = new StringBuilder();
             int c;
             try {
                 while( (c = br.read()) != -1)
                     str.append( (char)c);
                 stream = new StringInputText( str.toString());
                 br.close();
             } catch (IOException e) {

                e.printStackTrace();
             }
         }
         I_OutputText outStream = new SystemOutputText();

         FormatText formater = null;
         try {
             formater = new FormatText( stream, outStream);
         } catch (FormatterException e) {
             System.out.println( e.getMessage());
             e.printStackTrace();
         }
         formater.format();
     }


 }

