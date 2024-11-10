package com.others.sresta;

import java.io.OptionalDataException;

public class ArraysTest {
    public static void main(String[] args) {
        int ar[]={1,2,3,4,5};


int len=ar.length;
            int sum=0;//1
        for(int i = 0; i<ar.length; i++){
            sum=sum+ar[i];

        }
        System.out.println((len*(len+1)/2));
//        System.out.print(sum+" ");

    }
}
