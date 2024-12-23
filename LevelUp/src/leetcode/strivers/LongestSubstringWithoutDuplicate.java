package leetcode.strivers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplicate {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int len = s.length();
        int left = 0;
        int right = 0;
        int currLen = 0;
        int max = Integer.MIN_VALUE;
        //AASCII set size-256
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        while (right < len) {
            if (hash[s.charAt(right)] != -1) {
                if (hash[s.charAt(right)] >= left) {
                    left = hash[s.charAt(right)] + 1;
                }
            }
            currLen = right - left + 1;
            max = Math.max(currLen, max);
            hash[s.charAt(right)] = right;
            right++;
        }
        return max;
    }
}
