package com.algoprep.lu.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElements {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(10);
        queue.add(2);
        queue.add(12);
        queue.add(19);
        queue.add(6);
        queue.add(8);
        queue.add(10);
        queue.add(14);
        System.out.println(queue);
        reverseKElements(queue,5);
        System.out.println(queue);
    }

    public static void reverseKElements(Queue<Integer> queue, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        while (stack.size() != 0) {
            queue.add(stack.pop());
        }
        int con = Math.abs(queue.size() - k);
        for (int i = 0; i < con; i++) {
            int val = queue.poll();
            queue.add(val);
        }
    }
}
