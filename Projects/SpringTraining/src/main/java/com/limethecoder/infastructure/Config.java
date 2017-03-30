package com.limethecoder.infastructure;


public interface Config {
    Class<?> getImpl(String name);
}
