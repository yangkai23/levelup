package com.others;

public class JVMMemoryCheck {
    public static void main(String[] args) {
        long maxHeap = Runtime.getRuntime().maxMemory();
        long initialHeap = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();

        System.out.println("Initial Heap Size (-Xms): " + initialHeap / (1024 * 1024) + " MB");
        System.out.println("Max Heap Size (-Xmx): " + maxHeap / (1024 * 1024) + " MB");
        System.out.println("Free Memory: " + freeMemory / (1024 * 1024) + " MB");
    }
}
