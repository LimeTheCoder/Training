package com.limethecoder.pos.model;


public interface PointOfSale {
    int processRequest(PaymentRequest paymentRequest);
    int getTotalIncome();
}
