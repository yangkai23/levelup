package com.javaprep.concurrency.stampedlock;

import java.util.concurrent.locks.StampedLock;


public class SharedResource {
    int a=10;


    public void consume(StampedLock lock){
        long stamp = lock.writeLock();
        System.out.println("acquired write lock by "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
            a=20;
            System.out.println("Value changed to "+a+" by "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("released lock by "+Thread.currentThread().getName());
            lock.unlockWrite(stamp);
        }
    }
    public void produce(StampedLock lock){
        long stamp = lock.tryOptimisticRead();
        System.out.println("tryOptimisticRead started "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
            if(lock.validate(stamp)){
                System.out.println("tryOptimisticRead successful "+Thread.currentThread().getName());
                System.out.println("value read : "+a+" "+Thread.currentThread().getName());
            }
            else{
                System.out.println("tryOptimisticRead failed , rolling back "+Thread.currentThread().getName());
                a=10;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
