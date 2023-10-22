package com.algoprep.lu.msc;

import java.util.*;

public class MedianArr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ar[] = new int[scanner.nextInt()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(ar));
        median(ar);
        scanner.close();
    }

    public static void median(int[] ar) {

        if (ar.length > 0) System.out.println(ar[0]);
        int count = 1;
        for (int i = 1; i < ar.length; i++) {
            count++;
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j <= i; j++) {
                list.add(ar[j]);
            }
            Collections.sort(list);
            if (count % 2 != 0) System.out.println(list.get(i/2));
            else {
                System.out.println((list.get(i/2)+ list.get((i/2)+1)) / 2);
            }
        }
    }
}
