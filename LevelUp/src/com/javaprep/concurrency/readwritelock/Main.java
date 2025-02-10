package com.javaprep.concurrency.readwritelock;


import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {
        SharedResource resource1 = new SharedResource();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Thread t1 = new Thread(() -> {
            resource1.produce(lock);
        });
        Thread t2 = new Thread(() -> {
            resource1.produce(lock);
        });
        SharedResource resource2 = new SharedResource();
        Thread t3 = new Thread(() -> {
            resource2.consume(lock);
        });
        t1.start();
        t2.start();
        t3.start();

    }
}
