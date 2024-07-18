package com.algoprep.lu.bits;

import java.util.Scanner;

public class DivideTwoNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextInt();
        long div = scanner.nextInt();
        int result = getQuotient(num, div);
        System.out.println("Result : " + result);
        scanner.close();
    }

    private static int getQuotient(long num, long div) {
        int sign = 1;
        if (num < 0) sign *= -1;
        if (div < 0) sign *= -1;
        num = Math.abs(num);
        div = Math.abs(div);
        int quotient = 0;
        int temp = 0;
        for (int i = 31; i >= 0; i--) {
            if (temp + (div << i) <= num) {
                quotient += (1 << i);
                temp += (div << i);
            }

        }
        if (quotient > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (quotient < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return quotient * sign;
    }

}
