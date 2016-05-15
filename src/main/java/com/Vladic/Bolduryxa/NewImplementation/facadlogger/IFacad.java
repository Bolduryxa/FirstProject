package com.Vladic.Bolduryxa.NewImplementation.facadlogger;

/**
 *
 */
public interface IFacad {
    /**
     *
     * @param message 'message'
     */
    public void warn(final Object message);

    /**
     *
     * @param message 'message'
     */
    public void info(final Object message);
    /**
     *
     * @param message 'message'
     */
    public void error(final Object message);
    /**
     *
     * @param message 'message'
     */
    public void fatal(final Object message);

    /**
     *
     * @param message 'message'
     */
    public void debug(final Object message);
}
