package com.limethecoder.pos.model;


public interface PointOfSale {
    void processRequest(PaymentRequest paymentRequest);
    int getTotalIncome();
}
