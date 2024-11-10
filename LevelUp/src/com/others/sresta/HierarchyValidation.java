package com.others.sresta;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HierarchyValidation {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a>b");
        list.add("b>c");
        list.add("c>a");
        System.out.println(isConsistent(list));
    }

    public static boolean isConsistent(List<String> expressions) {
        //a>b , b>c , c>a
        char greater = '>';
        char lesser = '<';
        String bigger = "";
        String smaller = "";
        for (String s : expressions) {
            char a = s.charAt(0);
            char b = s.charAt(2);
            if (s.charAt(1) == greater) {
                bigger = bigger + a;
                smaller = smaller + b;
            } else {
                bigger = bigger + b;
                smaller = smaller + a;
            }

        }
        Set<Character> set = new HashSet<>();
        for (char c : bigger.toCharArray()) {
            if (!set.add(c)) return false;
        }
        Set<Character> set1 = new HashSet<>();
        for (char c : smaller.toCharArray()) {
            if (!set1.add(c)) return false;
        }
        return true;
        /*int[] ar = new int[26];
        for (int i = 0; i < bigger.length(); i++) {
            ar[bigger.charAt(i) - 'a']++;
        }
        for (int i = 0; i < smaller.length(); i++) {
            int loc = ar[smaller.charAt(i) - 'a'];
            if (loc == 1) {
                ar[smaller.charAt(i) - 'a'] = 0;
            }
        }
        for (int i = 0; i < ar.length; i++) {

            if (ar[i] == 1) return true;
        }*/
    }
}

