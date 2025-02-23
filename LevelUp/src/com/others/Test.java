package com.others;

public class Test {
    public static void main(String[] args) {
        System.out.println(Math.abs("ACQUISITION".hashCode()));
        System.out.println(System.currentTimeMillis());
        System.out.println(Math.abs("ACQUISITION".hashCode())+""+System.currentTimeMillis());
    }
}
