package com.algoprep.lu.bits;

import java.util.Scanner;

public class UnsetNthBit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int pos = scanner.nextInt();
        System.out.println(Integer.toBinaryString(num));
        int result = unsetNthBit(num, pos);
        System.out.println("Result : " + Integer.toBinaryString(result));
        scanner.close();
    }

    private static int unsetNthBit(int num, int pos) {
        int n = num;
        if (!CheckIthBitSet.isNthBitSet(num, pos)) {
            n = (num ^ (1 << pos));
        }
        return n;
    }
}
