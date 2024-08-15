package com.algoprep.lu.queue;

import java.util.LinkedList;
import java.util.Queue;

public class KthNumberUsing1and2 {
    public static void main(String[] args) {
        System.out.print(getNum(5));
    }

    public static int getNum(int k) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        String val = "";
        for (int i = 1; i <= k; i++) {
            val = queue.poll();
            queue.add(val + "1");
            queue.add(val + "2");
        }
        return Integer.parseInt(val);
    }
}
