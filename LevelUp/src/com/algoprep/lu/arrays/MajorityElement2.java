package com.algoprep.lu.arrays;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MajorityElement2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ar = new int[scanner.nextInt()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = scanner.nextInt();
        }
        System.out.println(getMajorityElement(ar));
        scanner.close();
    }

    private static List<Integer> getMajorityElement(int[] ar) {
        List<Integer> ans = new LinkedList<>();
        int num1 = ar[0];
        int count1 = 1;
        int num2 = Integer.MAX_VALUE;
        int count2 = 0;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] == num1) count1++;
            else if (ar[i] == num2) count2++;
            else if (count1 == 0) {
                num1 = ar[i];
                count1 = 1;
            } else if (count2 == 0) {
                num2 = ar[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        int c1 = 0;
        int c2 = 0;
        for (int val : ar) {
            if (val == num1) c1++;
            else if (val == num2) c2++;
        }
        int len = ar.length / 3;
        if (c1 > len) ans.add(num1);
        if (c2 > len) ans.add(num2);
        return ans;
    }
}
