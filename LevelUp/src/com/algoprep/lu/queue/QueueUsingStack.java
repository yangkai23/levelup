package com.algoprep.lu.queue;

import java.util.Stack;

public class QueueUsingStack {
    private static Stack<Integer> s1 = new Stack<>();
    private static Stack<Integer> s2 = new Stack<>();

    public static void add(Integer val) {
        s1.push(val);
    }

    public static void pop() {

        int n = s1.size();
        for (int i = 0; i < n - 1; i++) {
            s2.push(s1.pop());
        }
        int removedVal = s1.pop();
        for (int i = 0; i < n - 1; i++) {
            s1.push(s2.pop());
        }
    }

    public static void main(String[] args) {
        System.out.println(s1);
        add(2);
        add(63);
        add(3);
        pop();
        System.out.println(s1);
    }
}
