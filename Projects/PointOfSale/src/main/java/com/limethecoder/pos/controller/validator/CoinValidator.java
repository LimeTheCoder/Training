package com.limethecoder.pos.controller.validator;


public class CoinValidator implements Validator<Integer> {
    @Override
    public boolean isValid(Integer obj) {
        return true;
    }
}
