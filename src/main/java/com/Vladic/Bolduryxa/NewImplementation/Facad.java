package com.Vladic.Bolduryxa.NewImplementation;

import org.apache.log4j.Logger;

public class Facad implements IFacad {

    private Logger logger;

    private Facad(){
        throw new UnsupportedOperationException();
    }

    private Facad( Logger logger){
        this.logger = logger;
    }

    public static Facad getLogger( Class clazz){
        Logger logger = Logger.getLogger( clazz);
        return new Facad( logger);
    }

    @Override
    public void warn(Object message) {
        logger.warn( message);
    }

    @Override
    public void info(Object message) {

    }

    @Override
    public void error(Object message) {

    }

    @Override
    public void fatal(Object message) {

    }
}
