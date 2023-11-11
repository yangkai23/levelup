package com.algoprep.lu.bits;

import java.util.Scanner;

public class ThriceFrequentArrSingleElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int ar[] = new int[len];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = scanner.nextInt();
        }
        int result = getNum(ar);
        System.out.println("Result : " + result);
        scanner.close();
    }

    private static int getNum(int[] ar) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < ar.length; j++) {
                if (!CheckIthBitSet.isNthBitSet(ar[j], i)) count++;
            }
            if (count % 3 == 1) {
                result = result + (1 << i);
            }
        }
        return result;
    }

}
