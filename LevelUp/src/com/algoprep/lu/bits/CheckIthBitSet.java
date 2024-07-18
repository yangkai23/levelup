package com.algoprep.lu.bits;

import java.util.Scanner;

public class CheckIthBitSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int pos = scanner.nextInt();
        System.out.println(Integer.toBinaryString(num));
        boolean result = isNthBitSet(num, pos);
        System.out.println("Result : " + !result);
        scanner.close();
    }

    public static boolean isNthBitSet(int num, int pos) {
        return (num & (1 << pos)) == 0;
    }
}
