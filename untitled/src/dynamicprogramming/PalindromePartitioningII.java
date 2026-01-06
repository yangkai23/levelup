package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 06/01/26
 */
public class PalindromePartitioningII {
    public int minCut(String s) {

        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return fn(0, n, s, dp) - 1;
    }

    public int minCutUsingTabulation(String s) {


        int n = s.length();
        int[] dp = new int[n + 1];

        // precomputed palindrome table
        boolean[][] pal = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                        (j - i <= 2 || pal[i + 1][j - 1])) {
                    pal[i][j] = true;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int minCuts = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (pal[i][j]) {
                    int cuts = 1 + dp[j + 1];
                    minCuts = Math.min(minCuts, cuts);
                }
            }
            dp[i] = minCuts;
        }

        return dp[0] - 1;
    }

    static int fn(int i, int n, String s, int[] dp) {
        if (i == n)
            return 0;

        if (dp[i] != -1)
            return dp[i];
        int minCuts = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            if (isPalindrome(s, i, j)) {
                int cuts = 1 + fn(j + 1, n, s, dp);
                minCuts = Math.min(minCuts, cuts);
            }
        }
        dp[i] = minCuts;

        return minCuts;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}

