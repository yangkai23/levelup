package com.others.sresta;

import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int unit = scanner.nextInt();
        int km = scanner.nextInt();
        int output = switch (unit) {
            case 1 -> Math.multiplyExact(km, 1000);
            case 2 -> Math.multiplyExact(km, 100000);
            case 3 -> Math.multiplyExact(km, 1000000);
            default -> 0;
        };
        System.out.println(output);
    }
}
