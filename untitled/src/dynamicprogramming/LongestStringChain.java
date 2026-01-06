package dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Anirudh
 * @since 04/01/26
 */
public class LongestStringChain {
    public static void main(String[] args) {
        String[] words = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        System.out.println(longestStrChain(words));
    }

    /**
     * Finds the length of the longest possible string chain.
     * <p>
     * A string chain is formed if each word in the chain can be obtained
     * by inserting exactly one character into the previous word.
     * <p>
     * Approach:
     * - Sort the words by increasing length.
     * - Use dynamic programming where dp[i] represents the longest chain
     * ending at words[i].
     * - For each word, check all shorter words before it and see if they
     * are valid predecessors.
     * <p>
     * Time Complexity: O(n^2 * L)
     * - n = number of words
     * - L = average length of a word
     * <p>
     * Space Complexity: O(n)
     *
     * @param words array of strings
     * @return length of the longest string chain
     */
    public static int longestStrChain(String[] words) {

        // Sort words by length
        Arrays.sort(words, Comparator.comparingInt(String::length));

        int n = words.length;
        int max = 1;

        // dp[i] = length of longest chain ending at words[i]
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {

                // Check if words[prev] is a valid predecessor of words[i]
                if (compare(words[i], words[prev]) && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }


    /**
     * Checks whether string t is a valid predecessor of string s.
     * <p>
     * A valid predecessor means s can be formed by inserting exactly
     * one character into t without changing the order of existing characters.
     * <p>
     * Example:
     * t = "abc", s = "abac"  → true
     * t = "abc", s = "abcd"  → true
     * t = "abc", s = "abdc"  → true
     *
     * @param s longer string
     * @param t shorter string
     * @return true if t is a predecessor of s, false otherwise
     */
    static boolean compare(String s, String t) {

        // Length must differ by exactly one
        if (s.length() != t.length() + 1)
            return false;

        int i = 0, j = 0;

        // Two-pointer comparison
        while (i < s.length()) {
            if (j < t.length() && s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++; // skip the extra character in s
            }
        }

        // All characters of t must be matched
        return j == t.length();
    }

}
