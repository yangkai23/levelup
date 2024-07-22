package com.others;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ar[] = new int[sc.nextInt()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = sc.nextInt();
        }
        sortedArray(ar, 0, ar.length);
        System.out.println(Arrays.toString(ar));
        sc.close();
    }

    public static void sortedArray(int[] ar, int start, int end) {
        if (end-start <2)
            return;
        int mid = (start + end) / 2;
        sortedArray(ar, start, mid);
        sortedArray(ar, mid, end);
        merge(ar, start, mid, end);
    }

    public static void merge(int[] ar, int start, int mid, int end) {

        if (ar[mid - 1] <=  ar[mid])
            return;
        int i = start;
        int j = mid;
        int tempPointer = 0;
        int temp[] = new int[end - start];
        while (i < mid && j < end) {
            temp[tempPointer++] = ar[i] < ar[j] ? ar[i++] : ar[j++];
        }
        System.arraycopy(ar, i, ar, start+tempPointer, mid-i);
        System.arraycopy(temp, 0, ar, start,tempPointer );
    }
}
