package com.designpattern.strategy;

public class PaymentByUpi implements PaymentStrategy{
    @Override
    public void processPayment() {
        System.out.println("Payment By UPI");
    }
}
