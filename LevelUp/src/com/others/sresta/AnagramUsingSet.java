package com.others.sresta;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class AnagramUsingSet {
    public static void main(String[] args) {
        System.out.println(isAnagram("ani", "niw"));
    }

    private static boolean isAnagram(String s1, String s2) {
        HashSet<Character> set = new HashSet<>();
        for (char s1Char : s1.toCharArray()) {
            set.add(s1Char);
        }
        AtomicInteger atomicInteger=new AtomicInteger(0);
        atomicInteger.getAndIncrement();
        for (char s2Char : s2.toCharArray()) {
            boolean isPresent=set.add(s2Char);
            if (isPresent)
                return false;
        }
        return true;
    }
}
