package com.javaprep.concurrency.synchronizedd;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private boolean isAvailable=false;



    public synchronized void consume() {
        System.out.println(STR."acquired lock by \{Thread.currentThread().getName()}");
        isAvailable=true;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(STR."released lock by \{Thread.currentThread().getName()}");
    }

}