package com.algoprep.lu.maths;

import java.util.Scanner;

public class PrintAllPrimesSoEAlgo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPrimes(n);
        scanner.close();
    }
//This algorithm is called sieves of eratosthenes
    private static void printPrimes(int n) {
        boolean[] num = new boolean[n + 1];
        num[0] = num[1] = true;
        // i*i because if n is 50 , 7*7 =49, and we are iterating each num in nested loop
        for (int i = 2; i * i < n; i++) {
            if (!num[i]) {
                /*  j=i*i because 2*1=1 2*2=4 2*3=6 2*4=8 2*5=10
                * 3*1=3 3*2=6 3*3=9 3*4=12 3*5=15
                * 4*1=4 4*2=8 4*3=12 4*4=16 4*5=20
                * 5*1=5 5*2=10 5*3=15 5*4=20 5*5=25
                *   and so on .......
                *
                * if you observe above pattern before the value of i*i , every value has already occurred in prev num
                *
                * so for every num from i*i new value is getting started
                *
                * This will help us in Time complexity.
                *
                * T.C : O(nloglogn) S.C : O(n)
                *
                * */
                for (int j = i * i; j <= n; j += i)
                    num[j] = true;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!num[i]) System.out.print(i + " ");
        }
    }

}
