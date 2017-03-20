package com.limethecoder.pos.model;


public class PaymentRequest {
    private Sale sale = new Sale();
    private int coinsPayed = 0;

    public void addItemToBasket(SalesLineItem salesLineItem) {
        sale.addItemToSale(salesLineItem);
    }

    public void putCoin(Coin coin) {
        coinsPayed += coin.getValue();
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

    public int getCoinsPayed() {
        return coinsPayed;
    }

    public int getOddMoney() {
        return getCoinsPayed() - getTotalInvoice();
    }

    public int getMoneyLeftToPay() {
        int leftToPay = sale.getTotalPrice() - coinsPayed;
        return leftToPay < 0 ? 0 : leftToPay;
    }
}
