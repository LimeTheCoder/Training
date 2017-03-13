package com.limethecoder.pos.controller.validator;


public interface Validator<T> {
    boolean isValid(T obj);
}
