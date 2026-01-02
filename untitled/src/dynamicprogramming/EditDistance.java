package dynamicprogramming;

/**
 * @author Anirudh
 * @since 02/01/26
 */
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        return getDist(n - 1, m - 1, word1, word2);
    }

    /**
     * Computes the Edit Distance (Levenshtein Distance) between two strings
     * using a naive recursive approach.
     * <p>
     * Edit Distance is the minimum number of operations required to convert
     * one string into another. Allowed operations:
     * - Insert a character
     * - Delete a character
     * - Replace a character
     * <p>
     * Recurrence:
     * - If characters match, move diagonally (n-1, m-1)
     * - Otherwise, take minimum of:
     * insert (n, m-1)
     * delete (n-1, m)
     * replace (n-1, m-1)
     * <p>
     * Base Case:
     * - If one string is exhausted, the remaining length of the other string
     * is the required number of operations.
     * <p>
     * Time Complexity: O(3^(n+m)) (exponential)
     * Space Complexity: O(n + m) due to recursion stack
     *
     * @param n current index in string s (0-based)
     * @param m current index in string t (0-based)
     * @param s source string
     * @param t target string
     * @return minimum edit distance
     */
    static int getDist(int n, int m, String s, String t) {
        if (n < 0) return m + 1;
        if (m < 0) return n + 1;

        if (s.charAt(n) == t.charAt(m)) {
            return getDist(n - 1, m - 1, s, t);
        }

        int add = 1 + getDist(n, m - 1, s, t);
        int delete = 1 + getDist(n - 1, m, s, t);
        int replace = 1 + getDist(n - 1, m - 1, s, t);

        return Math.min(add, Math.min(delete, replace));
    }


    /**
     * Computes the Edit Distance using top-down dynamic programming
     * (recursion + memoization).
     * <p>
     * dp[n][m] stores the minimum edit distance between
     * the first n characters of s and the first m characters of t.
     * <p>
     * Base Case:
     * - If n == 0, all remaining characters of t must be inserted
     * - If m == 0, all remaining characters of s must be deleted
     * <p>
     * Time Complexity: O(n * m)
     * Space Complexity: O(n * m) + recursion stack
     *
     * @param n  length of prefix of s being considered
     * @param m  length of prefix of t being considered
     * @param s  source string
     * @param t  target string
     * @param dp memoization table
     * @return minimum edit distance
     */
    static int getDist(int n, int m, String s, String t, int[][] dp) {

        if (n == 0) return m;
        if (m == 0) return n;

        if (dp[n][m] != -1) return dp[n][m];

        if (s.charAt(n - 1) == t.charAt(m - 1)) {
            dp[n][m] = getDist(n - 1, m - 1, s, t, dp);
        } else {
            int add = 1 + getDist(n, m - 1, s, t, dp);
            int delete = 1 + getDist(n - 1, m, s, t, dp);
            int replace = 1 + getDist(n - 1, m - 1, s, t, dp);
            dp[n][m] = Math.min(add, Math.min(delete, replace));
        }

        return dp[n][m];
    }


    /**
     * Computes the Edit Distance using bottom-up dynamic programming
     * (tabulation).
     * <p>
     * DP Definition:
     * dp[i][j] represents the minimum number of operations required to
     * convert the first i characters of s into the first j characters of t.
     * <p>
     * Base Initialization:
     * - dp[i][0] = i (delete all characters)
     * - dp[0][j] = j (insert all characters)
     * <p>
     * Time Complexity: O(n * m)
     * Space Complexity: O(n * m)
     *
     * @param s source string
     * @param t target string
     * @return minimum edit distance
     */
    public static int minDistanceUsingTabulation(String s, String t) {

        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int add = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(add, Math.min(delete, replace));
                }
            }
        }
        return dp[n][m];
    }


    /**
     * Computes the Edit Distance using space-optimized bottom-up DP.
     * <p>
     * Only two rows are required at any time:
     * - prev[] represents dp[i-1][*]
     * - curr[] represents dp[i][*]
     * <p>
     * This reduces space usage from O(n * m) to O(m).
     * <p>
     * Time Complexity: O(n * m)
     * Space Complexity: O(m)
     *
     * @param s source string
     * @param t target string
     * @return minimum edit distance
     */
    public static int minDistanceUsingTabulationWithSpaceOptimization(
            String s, String t) {

        int n = s.length();
        int m = t.length();

        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= n; i++) {
            curr[0] = i;

            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    int add = 1 + curr[j - 1];
                    int delete = 1 + prev[j];
                    int replace = 1 + prev[j - 1];
                    curr[j] = Math.min(add, Math.min(delete, replace));
                }
            }
            System.arraycopy(curr, 0, prev, 0, m + 1);
        }
        return prev[m];
    }

}
