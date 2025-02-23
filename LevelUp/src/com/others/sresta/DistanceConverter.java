package com.others.sresta;

import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int unit = scanner.nextInt();
        int km = scanner.nextInt();
        int output = 0;
        switch (unit) {
            case 1:
                output = Math.multiplyExact(km, 1000);
                break;
            case 2:
                output = Math.multiplyExact(km, 100000);
                break;
            case 3:
                output = Math.multiplyExact(km, 1000000);
                break;

        }
        System.out.println(output);
    }
}
