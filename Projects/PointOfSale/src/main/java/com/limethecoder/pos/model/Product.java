package com.limethecoder.pos.model;


import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum Product {
    TEA(25, "Cold tea with lemon"),
    COFFEE(35, "Bitter coffee from Turkey"),
    JUICE(45, "Fresh juice from apple and carrot");

    private int price;
    private String description;

    Product(int price, String description) {
        this.price = price;
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public static Set<String> getProductNames() {
        return Arrays.stream(values()).map(Product::name)
                .collect(Collectors.toSet());
    }
}
