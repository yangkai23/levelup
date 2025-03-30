package com.others.sresta;

public class LuckyNumber {
    public static void main(String[] args) {
//        System.out.println(numerology(7,"WILLIAM"));
    }

    public int numerology(int input1, String input2) {
        int result = 0;
        for (int i = 0; i < input2.length(); i++) {
            if ((int) (input2.charAt(i)) % 2 == 0 && (i + 1) % 2 == 0) continue;
            int val = Math.multiplyExact(input2.charAt(i), i + 1);
            result += val;

        }
        return result;
    }
}
