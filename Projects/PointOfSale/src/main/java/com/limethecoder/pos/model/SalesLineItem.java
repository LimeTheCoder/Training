package com.limethecoder.pos.model;


public class SalesLineItem{
    private int quantity;
    private Product product;

    public SalesLineItem(Product product, int quantity) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getTotalPrice() {
        return quantity * product.getPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }
}
