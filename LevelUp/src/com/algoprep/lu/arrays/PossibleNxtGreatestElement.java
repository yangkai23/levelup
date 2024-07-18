package com.algoprep.lu.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class PossibleNxtGreatestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] ar = new char[scanner.nextInt()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = scanner.next().charAt(0);
        }
        System.out.println(getNxtInt(ar));
        scanner.close();
    }

    private static int getNxtInt(char[] ar) {
//        int num = Integer.parseInt(String.valueOf(ar));
        int len = ar.length;
        int max = len - 1;
        int idx = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (ar[i] > ar[max]) {
                max = i;
            } else {
                idx = i;
                break;
            }
        }
        System.out.println("idx : " + idx);
        System.out.println("curr : " + max);
        if (idx == -1) return -1;
        int minDiff = ar[max] - ar[idx];
        int swapIdx = max;
        for (int i = max + 1; i < len; i++) {
            if (ar[i] > ar[idx]) {
                if (minDiff > (Math.abs(ar[i] - ar[idx]))) {
                    swapIdx = i;
                }
            } else break;
        }
        char temp = ar[idx];
        ar[idx] = ar[swapIdx];
        ar[swapIdx] = temp;
        System.out.println(Arrays.toString(ar));
        Arrays.sort(ar, max, len);
        long ans = Long.parseLong(String.valueOf(ar));
        if (ans > Integer.MAX_VALUE) return -1;
        else return (int) ans;
    }
}
