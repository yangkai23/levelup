package dynamicprogramming;

/**
 * @author Anirudh
 * @since 31/12/25
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(findLcsUsingTabulation("abaaa", "baabaca"));
    }

    /**
     * Computes the length of the Longest Common Subsequence (LCS) between
     * two given strings using a recursive approach.
     * <p>
     * A subsequence is a sequence that can be derived from another sequence
     * by deleting some or no elements without changing the order of the
     * remaining elements.
     * <p>
     * This implementation uses plain recursion:
     * - If the current characters match, include it in the LCS.
     * - Otherwise, try both possibilities by skipping one character from
     * either string and take the maximum.
     * <p>
     * Time Complexity: O(2^(n + m)) (worst case)
     * Space Complexity: O(n + m) due to recursion stack
     *
     * @param text1 first input string
     * @param text2 second input string
     * @return length of the longest common subsequence
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        return findLcs(n1 - 1, n2 - 1, text1.toCharArray(), text2.toCharArray());
    }

    /**
     * Recursive helper method to compute LCS length.
     * Note:
     * This solution does NOT use memoization and hence has exponential
     * time complexity. It is mainly useful for understanding the problem
     * or as a base for memoization / tabulation.
     *
     * @param idx1  current index in the first character array
     * @param idx2  current index in the second character array
     * @param text1 character array of the first string
     * @param text2 character array of the second string
     * @return length of the longest common subsequence up to the given indices
     */


    static int findLcs(int idx1, int idx2, char[] text1, char[] text2) {
        // Base case: one of the strings is exhausted
        if (idx1 < 0 || idx2 < 0) return 0;

        // Character match: include in LCS
        if (text1[idx1] == text2[idx2]) {
            return 1 + findLcs(idx1 - 1, idx2 - 1, text1, text2);
        }

        // Characters do not match: explore both possibilities
        return Math.max(findLcs(idx1 - 1, idx2, text1, text2), findLcs(idx1, idx2 - 1, text1, text2));
    }

    static int findLcs(int idx1, int idx2, char[] text1, char[] text2, int[][] dp) {
        if (idx1 < 0 || idx2 < 0)
            return 0;

        if (dp[idx1][idx2] != -1)
            return dp[idx1][idx2];

        if (text1[idx1] == text2[idx2]) {
            dp[idx1][idx2] = 1 + findLcs(idx1 - 1, idx2 - 1, text1, text2, dp);
            return dp[idx1][idx2];
        }
        dp[idx1][idx2] = Math.max(findLcs(idx1 - 1, idx2, text1, text2, dp), findLcs(idx1, idx2 - 1, text1, text2, dp));
        return dp[idx1][idx2];
    }

    /**
     * Computes the length of the Longest Common Subsequence (LCS) between
     * two character arrays using bottom-up dynamic programming (tabulation).
     * <p>
     * DP Definition:
     * dp[i][j] represents the length of the LCS between
     * the first i characters of text1 and the first j characters of text2.
     * <p>
     * Transition:
     * - If text1[i-1] == text2[j-1]:
     * dp[i][j] = 1 + dp[i-1][j-1]
     * - Else:
     * dp[i][j] = max(dp[i-1][j], dp[i][j-1])
     * <p>
     * Base Case:
     * - dp[0][*] = 0 (empty string vs any string)
     * - dp[*][0] = 0
     * <p>
     * Time Complexity: O(n1 * n2)
     * Space Complexity: O(n1 * n2)
     *
     * @param text1 character array of the first string
     * @param text2 character array of the second string
     * @return length of the longest common subsequence
     */
    static int findLcsUsingTabulation(String text1, String text2) {

        int n1 = text1.length();
        int n2 = text2.length();

        // dp[i][j] = LCS length for first i chars of text1 and first j chars of text2
        int[][] dp = new int[n1 + 1][n2 + 1];

        // Base cases are implicitly 0 due to Java default initialization

        for (int idx1 = 1; idx1 <= n1; idx1++) {
            for (int idx2 = 1; idx2 <= n2; idx2++) {

                // Character match
                if (text1.charAt(idx1 - 1) == text2.charAt(idx2 - 1)) {
                    dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];
                }
                // Characters do not match
                else {
                    dp[idx1][idx2] = Math.max(
                            dp[idx1 - 1][idx2],
                            dp[idx1][idx2 - 1]
                    );
                }
            }
        }


        for (int i = 0; i < n1 + 1; i++) {
            for (int j = 0; j < n2 + 1; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n1][n2];
    }


    public static int findLcsUsingTabulationWithSpaceOptimization(String text1, String text2) {

        int n1 = text1.length();
        int n2 = text2.length();

        int[] prev = new int[n2 + 1];
        int[] curr = new int[n2 + 1];

        for (int idx1 = 1; idx1 <= n1; idx1++) {
            for (int idx2 = 1; idx2 <= n2; idx2++) {

                if (text1.charAt(idx1 - 1) == text2.charAt(idx2 - 1)) {
                    curr[idx2] = 1 + prev[idx2 - 1];
                } else {
                    curr[idx2] = Math.max(prev[idx2], curr[idx2 - 1]);
                }
            }

            // Move current row to previous row for next iteration
            System.arraycopy(curr, 0, prev, 0, n2 + 1);
        }

        return prev[n2];
    }


}
