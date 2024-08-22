package com.algoprep.lu.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FirstKSmallest {
    public static void main(String[] args) {
        int[] ar = {5, 4, 8, 24, 1, 6};
        int k = 4;
        printKElements(ar, k);
    }

    private static void printKElements(int[] ar, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            pq.add(ar[i]);
        }
        int len = ar.length;
        for (int i = k; i < len; i++) {
            if (pq.peek() > ar[i]) {
                pq.add(ar[i]);
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
