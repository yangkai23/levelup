package com.javaprep.concurrency.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        SharedResource resource1=new SharedResource();
        SharedResource resource2=new SharedResource();
        Lock lock=new ReentrantLock();
        Thread t1=new Thread(()->{resource1.consume(lock);});
        Thread t2=new Thread(()->{resource2.consume(lock);});
        t1.start();
        t2.start();
    }
}
