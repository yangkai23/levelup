package com.algoprep.lu.stack;


import java.util.Stack;

public class AdjacentRemove {
    public static void main(String[] args) {
        removeAdjacentElements("abbad");
    }

    public static void removeAdjacentElements(String value) {
        if (value == null || value.trim().length() == 0)
            return;
        int len = value.length();
        Stack<Character> list = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = value.charAt(i);
            if (list.size() == 0) {
                list.push(c);
                continue;
            }
            if (list.peek() != c)
                list.pop();
            else
                list.push(c);
        }
        System.out.println(list);
    }
}
