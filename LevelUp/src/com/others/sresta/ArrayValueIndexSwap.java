package com.others.sresta;

import java.util.Scanner;

public class ArrayValueIndexSwap {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int size=scanner.nextInt();
        int[] ar=new int[size];
        for(int i=0;i<size;i++){
            ar[i]=scanner.nextInt();
        }
        int[] temp=new int[size];
        for(int i=0;i<ar.length;i++){
            temp[ar[i]]=i;
        }
        for(int i=0;i<ar.length;i++){
            System.out.print(temp[i]+" ");
        }
    }
}
