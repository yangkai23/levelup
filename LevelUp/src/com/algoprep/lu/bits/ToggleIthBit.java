package com.algoprep.lu.bits;

import java.util.Scanner;

public class ToggleIthBit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int pos = scanner.nextInt();
        System.out.println(Integer.toBinaryString(num));
        int result = toggleIthBit(num, pos);
        System.out.println("Result : " + Integer.toBinaryString(result));
        scanner.close();
    }

    private static int toggleIthBit(int num, int pos) {
        int n = (num ^ (1 << pos));
        return n;
    }
}
