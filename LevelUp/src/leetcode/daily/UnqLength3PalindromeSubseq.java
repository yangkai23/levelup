package leetcode.daily;

import java.util.HashMap;
import java.util.HashSet;

public class UnqLength3PalindromeSubseq {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("bbcbaba"));
    }

    public static int countPalindromicSubsequence(String s) {
        if (s == null || s.trim().isEmpty()) return 0;
        int len = s.length();
        HashMap<Character, Integer> startIndex = new HashMap<>();
        HashMap<Character, Integer> lasIndex = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (!startIndex.containsKey(c)) {
                startIndex.put(c, i);
            }
            lasIndex.put(c, i);
        }
        int res = 0;
        for (char c : startIndex.keySet()) {
            int first = startIndex.get(c);
            int last = lasIndex.get(c);
            if (first != last) {
                HashSet<Character> set = new HashSet<>();
                for (int j = first + 1; j < last; j++) {
                    set.add(s.charAt(j));
                }
                res += set.size();
            }
        }


        return res;
    }
}
