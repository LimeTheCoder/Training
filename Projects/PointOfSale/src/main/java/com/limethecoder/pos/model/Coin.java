package com.limethecoder.pos.model;


import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum Coin {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25), HALF_DOLLAR(50);

    private int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Coin valueOf(int value) {
        return Arrays.stream(Coin.values())
                .filter(coin -> coin.getValue() == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Set<Integer> getValidCoins() {
        return Arrays.stream(Coin.values())
                .map(Coin::getValue)
                .collect(Collectors.toSet());
    }
}
