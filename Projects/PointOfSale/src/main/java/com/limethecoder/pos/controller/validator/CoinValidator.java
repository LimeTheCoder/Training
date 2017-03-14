package com.limethecoder.pos.controller.validator;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CoinValidator implements Validator<Integer> {
    private final static Set<Integer> VALID_COINS =
            Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 5, 10, 25, 50)));

    @Override
    public boolean isValid(Integer coin) {
        return VALID_COINS.contains(coin);
    }
}
