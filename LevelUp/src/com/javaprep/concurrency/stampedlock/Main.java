package com.javaprep.concurrency.stampedlock;


import java.util.concurrent.locks.StampedLock;

public class Main {
    public static void main(String[] args) {
        StampedLock lock=new StampedLock();
        SharedResource resource=new SharedResource();
        Thread t1=new Thread(()->{resource.produce(lock);});
        Thread t2=new Thread(()->{resource.consume(lock);});
        t1.start();
        t2.start();
    }
}
