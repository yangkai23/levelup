package com.algoprep.lu.bits;

import java.util.Scanner;

public class NumOfSetBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(Integer.toBinaryString(num));
        int result = getNumOfSetBits(num);
        System.out.println("Result : " + result);
        scanner.close();
    }

    private static int getNumOfSetBits(int num) {
        //max is 32 because int range is 32 bits
        int setCount = 0;
        for (int i = 0; i < 32; i++) {
            if (!CheckIthBitSet.isNthBitSet(num, i)) setCount++;
        }
        return setCount;
    }
}
