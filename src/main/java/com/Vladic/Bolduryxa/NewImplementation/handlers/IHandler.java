package com.Vladic.Bolduryxa.NewImplementation.handlers;

/**
 * Interface for symbol processing
 *
 * @author Vladiclav
 * @see com.Vladic.Bolduryxa.NewImplementation.factorymethod.HandlerFactory
 * @see com.Vladic.Bolduryxa.NewImplementation.formatter.Formatter

 * @see com.Vladic.Bolduryxa.NewImplementation.handlers.DeleteDoubleSpace
 * @see com.Vladic.Bolduryxa.NewImplementation.handlers.LeftBrace
 * @see com.Vladic.Bolduryxa.NewImplementation.handlers.LeftParenthesis

 * @see com.Vladic.Bolduryxa.NewImplementation.handlers.TransferLine
 * @since JDK 1.8
 */
public interface IHandler {


    /**
     *
     * @param input 'input'
     * @return
     */
    String execute(final String input);
}
