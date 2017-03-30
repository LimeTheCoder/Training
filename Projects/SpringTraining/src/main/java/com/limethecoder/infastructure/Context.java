package com.limethecoder.infastructure;


public interface Context {
    <T> T getBean(String beanName);
}
