package com.designpattern.strategy;

public class PaymentService {
    PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public static void main(String[] args) {
        PaymentStrategy paymentByCard = new PaymentByCard();
        PaymentService paymentService = new PaymentService(paymentByCard);
        paymentService.processOrder();
        PaymentStrategy paymentByUPI = new PaymentByUpi();
        PaymentService paymentService1 = new PaymentService(paymentByUPI);
        paymentService1.processOrder();
    }

    public void processOrder() {
        this.paymentStrategy.processPayment();
    }
}
