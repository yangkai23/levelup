package dynamicprogramming;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Anirudh
 * @since 31/12/25
 */
public class PrintLongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(findLcsUsingTabulation("delete", "leet"));
    }

    static int findLcsUsingTabulation(String text1, String text2) {

        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        // Step 1: Build DP table
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 2: Reconstruct LCS
        int i = n1, j = n2;
        int len = dp[n1][n2];
        char[] lcs = new char[len];
        int idx = len - 1;

        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                lcs[idx--] = text1.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // Step 3: Print LCS
        System.out.println("LCS: " + new String(lcs));

        return len;
    }

}
