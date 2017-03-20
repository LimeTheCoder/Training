package com.limethecoder.pos.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class VendorMachine implements PointOfSale {
    private Set<Sale> sales = new HashSet<>();

    public int processRequest(PaymentRequest paymentRequest) {
        if (!paymentRequest.isPayed()) {
            throw new IllegalStateException();
        }

        Sale sale = paymentRequest.getSale();
        sale.setDate(new Date());
        sales.add(sale);

        return paymentRequest.getOddMoney();
    }

    public int getTotalIncome() {
        return sales
                .stream()
                .mapToInt(Sale::getTotalPrice)
                .sum();
    }

    public Set<Sale> getSales() {
        return sales;
    }
}
