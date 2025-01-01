package leetcode.daily;

import java.util.Arrays;

public class MaxScoresStringSplit {
    public static void main(String[] args) {
        System.out.println(maxScore("00"));
    }

    public static int maxScore(String s) {
        if (s == null || s.trim().isEmpty()) return 0;
        int len = s.length();
        int ones = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') ones++;
        }
        int zeroes = 0;
        int res = 0;
        for (int i = 0; i < len-1; i++) {
            if (s.charAt(i) == '0') zeroes++;
            else ones--;
            res = Math.max(res, (zeroes + ones));
        }
        return res;
    }

}
