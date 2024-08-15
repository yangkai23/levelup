package com.algoprep.lu.stack;

import java.util.Stack;

public class BasicValidParenthesis {
    public static boolean isValid(String input) {
        if (input == null) return false;
        int len = input.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if (stack.size() == 0) {
                stack.push(c);
                continue;
            }
            if (c == '}' && stack.peek() != '{') {

                return false;
            } else if (c == ')' && stack.peek() != '(') {
                return false;
            } else if (c == ']' && stack.peek() != '[') {
                return false;
            } else {
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else stack.pop();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "{[]([])}";
        System.out.println(isValid(input));
    }
}



