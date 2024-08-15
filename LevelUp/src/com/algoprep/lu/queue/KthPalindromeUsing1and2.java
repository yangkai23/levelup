package com.algoprep.lu.queue;

import java.util.LinkedList;
import java.util.Queue;

public class KthPalindromeUsing1and2 {


    public static void main(String[] args) {
        System.out.print(getPalindrome(16));
    }

    private static String getPalindrome(int k) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        String val = "";
        for (int i = 1; i <= k; i++) {
            val = queue.poll();
            //can be added in between too
            queue.add("1" + val + "1");
            queue.add("2" + val + "2");
        }
        return val;

    }
}
