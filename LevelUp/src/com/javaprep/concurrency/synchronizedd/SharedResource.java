package com.javaprep.concurrency.synchronizedd;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private boolean isAvailable=false;



    public synchronized void consume() {
        isAvailable=true;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}