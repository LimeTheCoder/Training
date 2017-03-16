package com.limethecoder.pos.model;


public class PaymentRequest {
    private Sale sale = new Sale();
    private int coinsPayed = 0;

    public void addItemToBasket(SalesLineItem salesLineItem) {
        sale.addItemToSale(salesLineItem);
    }

    public void putCoin(int coin) {
        coinsPayed += coin;
    }

    public boolean isPayed() {
        return getMoneyLeftToPay() == 0;
    }

    public Sale getSale() {
        return sale;
    }

    public int getTotalInvoice() {
        return sale.getTotalPrice();
    }

    public int getMoneyLeftToPay() {
        int leftToPay = sale.getTotalPrice() - coinsPayed;
        return leftToPay < 0 ? 0 : leftToPay;
    }
}
