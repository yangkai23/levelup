package com.algoprep.lu.bits;

import java.util.Scanner;

public class SingleElement {
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
        int result = ar[0];
        for (int i = 1; i < ar.length; i++) {
            result = result ^ ar[i];
        }
        return result;
    }


}
