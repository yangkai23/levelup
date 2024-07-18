package com.algoprep.lu.bits;

import java.util.Scanner;

public class TwiceFrequentTwiceElement {
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
        int ans = ar[0];
        for (int i = 1; i < ar.length; i++) {
            ans = ans ^ ar[i];
        }
        int idx = 0;
        for (int i = 0; i < 32; i++) {
            if (!CheckIthBitSet.isNthBitSet(ans, i)) {
                idx = i;
                break;
            }
        }
        int set1 = 0;
        int set2 = 0;
        for (int i = 0; i < ar.length; i++) {
            if (!CheckIthBitSet.isNthBitSet(ar[i], idx)) {
                set2 = set2 ^ ar[i];
            } else set1 = set1 ^ ar[i];
        }
        return ans;
    }
}
