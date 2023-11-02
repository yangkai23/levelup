package com.algoprep.lu.arrays;

import java.util.Scanner;

public class MajorityElement1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ar = new int[scanner.nextInt()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = scanner.nextInt();
        }
        System.out.println(getMajorityElement(ar));
        scanner.close();
    }

    private static int getMajorityElement(int[] ar) {
        int val = ar[0];
        int count = 0;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] == val) count++;
            else {
                if (count == 0) val = ar[i];
                else count--;
            }
        }
        return val;
    }
}
