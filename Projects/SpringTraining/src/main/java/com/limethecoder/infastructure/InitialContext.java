package com.limethecoder.infastructure;

/* For service locator. Only responsible for bean loading */
public class InitialContext {
    private Config config;

    public InitialContext(Config config) {
        this.config = config;
    }

    public Object lookup(String name) {
        try {
            return config.getImpl(name).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
