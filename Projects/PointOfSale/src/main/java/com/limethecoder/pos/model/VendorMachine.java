package com.limethecoder.pos.model;


import java.util.HashSet;
import java.util.Set;

public class VendorMachine {
    private Set<Sale> sales = new HashSet<>();

    public int getTotalIncome() {
        return sales
                .stream()
                .mapToInt(Sale::getTotalPrice)
                .sum();
    }
}
