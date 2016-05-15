/**
 *
 */
package com.Vladic.Bolduryxa.NewImplementation.facadlogger;

import org.apache.log4j.Logger;

/**
 *
 */
public class Facad implements IFacad {
    /**
     *
     */
    private Logger logger;

    /**
     *
     */
    private Facad(){
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param logger 'logger'
     */
    private Facad(final Logger logger){
        this.logger = logger;
    }

    /**
     *
     * @param clazz 'clazz'
     * @return
     */
    public static Facad getLogger(final Class clazz){
        Logger logger = Logger.getLogger(clazz);
        return new Facad(logger);
    }


    @Override
    public void warn(final Object message) {
        logger.warn(message);
    }

    @Override
    public void info(final Object message) {
        logger.info(message);

    }

    @Override
    public void error(final Object message) {
        logger.error(message);
    }

    @Override
    public void fatal(final Object message) {
        logger.fatal(message);
    }
    @Override
    public void debug(final Object message) {
        logger.debug(message);
    }
}
