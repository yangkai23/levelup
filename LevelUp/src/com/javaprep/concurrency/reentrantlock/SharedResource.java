package com.javaprep.concurrency.reentrantlock;

import java.util.concurrent.locks.Lock;




public class SharedResource {
    private boolean isAvailable=false;

    public void consume(Lock lock){
        lock.lock();
        System.out.println("acquired lock by "+Thread.currentThread().getName());
        isAvailable=true;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("released lock by "+Thread.currentThread().getName());
            lock.unlock();
        }
    }
}
