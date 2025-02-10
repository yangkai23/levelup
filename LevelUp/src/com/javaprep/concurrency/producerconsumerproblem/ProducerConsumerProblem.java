package com.javaprep.concurrency.producerconsumerproblem;

public class ProducerConsumerProblem {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(7);
        System.out.println(Thread.currentThread().getPriority());
        Thread producer = new Thread(() -> {
            for (int i = 1; i < 100; i++) {
                sharedResource.produce(i);
            }
        });
        Thread consumer = new Thread(() -> {
            for (int i = 1; i < 100; i++) {
                sharedResource.consume();
            }
        });

        producer.start();
        consumer.start();
    }
}
