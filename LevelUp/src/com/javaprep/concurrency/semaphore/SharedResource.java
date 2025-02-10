package com.javaprep.concurrency.semaphore;


import java.util.concurrent.Semaphore;

public class SharedResource {
    boolean isAvailable=false;

    public void produce(Semaphore lock){

        try {
            lock.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+" acquired lock");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println(Thread.currentThread().getName()+" released lock");
            lock.release();
        }
    }
}
