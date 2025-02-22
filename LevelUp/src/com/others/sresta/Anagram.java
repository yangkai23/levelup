package com.others.sresta;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("ani", "ni"));
    }

    public static boolean isAnagram(String s1, String s2) {
        if(s1.length()!=s2.length())
            return false;
        boolean isAnagram = true;
        for (int i = 0; i < s1.length(); i++) {
            boolean charMatch = false;
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    charMatch = true;
                    break;
                }
            }
            if (!charMatch) {
                return false;
            }
        }
        return isAnagram;
    }
}
