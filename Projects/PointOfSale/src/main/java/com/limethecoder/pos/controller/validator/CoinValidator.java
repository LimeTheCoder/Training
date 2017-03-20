package com.limethecoder.pos.controller.validator;


import com.limethecoder.pos.model.Coin;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CoinValidator implements Validator<Integer> {
    private final static Set<Integer> VALID_COINS =
            Collections.unmodifiableSet(Coin.getValidCoins());

    @Override
    public boolean isValid(Integer coin) {
        return VALID_COINS.contains(coin);
    }
}
