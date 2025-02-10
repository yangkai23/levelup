package com.javaprep.concurrency.condition;


import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerProblem {
    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock();
        SharedResource sharedResource = new SharedResource(lock);
        Thread producer = new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                sharedResource.produce();
            }
        });
        Thread consumer = new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                sharedResource.consume();
            }
        });

        producer.start();
        consumer.start();
    }
}
