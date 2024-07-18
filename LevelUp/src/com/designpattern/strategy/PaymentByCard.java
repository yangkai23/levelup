package com.designpattern.strategy;

public class PaymentByCard implements PaymentStrategy{
    @Override
    public void processPayment() {
        System.out.println("Payment By Card");
    }
}
