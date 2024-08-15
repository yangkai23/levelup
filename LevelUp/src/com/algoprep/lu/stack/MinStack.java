package com.algoprep.lu.stack;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        int ar[] = {11, 10, 12, 7, 25};
        System.out.println(getMin(ar));
    }

    private static Stack<Integer> getMin(int[] ar) {
        Stack<Integer> regstack = new Stack<>();
        Stack<Integer> minstack = new Stack<>();
        for (int val : ar) {
            if (regstack.size() == 0) {
                regstack.push(val);
                minstack.push(val);
                continue;
            }
            regstack.push(val);
            minstack.push(Math.min(minstack.peek(), val));

        }

        return minstack;
    }
}
