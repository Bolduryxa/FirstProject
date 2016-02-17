package com.Vladic.Bolduryxa.NewImplementation.Interfaces;

/**
 * Interface for symbol processing
 *
 * @author Vladiclav
 * @see com.Vladic.Bolduryxa.NewImplementation.FactoryMethod.HandlerFactory
 * @see com.Vladic.Bolduryxa.NewImplementation.Formatter.Formatter

 * @see com.Vladic.Bolduryxa.NewImplementation.Handlers.DeleteDoubleSpace
 * @see com.Vladic.Bolduryxa.NewImplementation.Handlers.LeftBrace
 * @see com.Vladic.Bolduryxa.NewImplementation.Handlers.LeftParenthesis

 * @see com.Vladic.Bolduryxa.NewImplementation.Handlers.TransferLine
 * @since JDK 1.8
 */
public interface I_Handler {



    public boolean execute( char inputChar, I_OutputStream outputStream);
}
