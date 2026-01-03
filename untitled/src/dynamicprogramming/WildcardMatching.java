package dynamicprogramming;

/**
 * @author Anirudh
 * @since 02/01/26
 */
public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        return match(n - 1, m - 1, s, p);
    }

    static boolean match(int n, int m, String s, String p) {
        // n-> str index
        // m-> pattern index

        if (n < 0 && m < 0)
            return true;
        if (m < 0 && n >= 0)
            return false;
        if (n < 0 && m >= 0) {
            for (int i = 0; i <= m; i++) {
                if (p.charAt(i) != '*')
                    return false;
            }
            return true;
        }

        if (s.charAt(n) == p.charAt(m) || p.charAt(m) == '?') {
            return match(n - 1, m - 1, s, p);
        } else {
            if (p.charAt(m) == '*') {
                return match(n, m - 1, s, p) || match(n - 1, m, s, p);
            } else {
                return false;
            }

        }

    }

    static boolean match(int n, int m, String s, String p, int[][] dp) {
        // n-> str index
        // m-> pattern index

        if (n == 0 && m == 0)
            return true;
        if (m == 0 && n > 0)
            return false;
        if (n == 0 && m > 0) {
            for (int i = 1; i <= m; i++) {
                if (p.charAt(i - 1) != '*')
                    return false;
            }
            return true;
        }

        if (dp[n][m] != -1)
            return dp[n][m] == 1;

        if (s.charAt(n - 1) == p.charAt(m - 1) || p.charAt(m - 1) == '?') {
            dp[n][m] = match(n - 1, m - 1, s, p, dp) ? 1 : 0;
        } else {
            if (p.charAt(m - 1) == '*') {
                dp[n][m] = (match(n, m - 1, s, p, dp) || match(n - 1, m, s, p, dp)) ? 1 : 0;
            } else {
                dp[n][m] = 0;
            }

        }
        return dp[n][m] == 1;

    }

    public static boolean isMatchUsingTabulation(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // base case

        dp[0][0] = true;
        // if (m == 0 && n > 0) - no need to mark it as false since default is false

        for (int j = 1; j <= m; j++) {
            boolean flag = true;
            for (int i = 1; i <= j; i++) {
                if (p.charAt(i - 1) != '*') {
                    flag = false;
                    break;
                }

            }

            dp[0][j] = flag;
        }

        // indexes usage

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    } else {
                        dp[i][j] = false;
                    }

                }
            }
        }

        return dp[n][m];
    }

    public static boolean isMatchUsingTabulationWithSpaceOptimization(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[] curr = new boolean[m + 1];
        boolean[] prev = new boolean[m + 1];
        // boolean[][] dp = new boolean[n + 1][m + x1];

        // base case

        prev[0] = true;
        // if (m == 0 && n > 0) - no need to mark it as false since default is false

        for (int j = 1; j <= m; j++) {
            boolean flag = true;
            for (int i = 1; i <= j; i++) {
                if (p.charAt(i - 1) != '*') {
                    flag = false;
                    break;
                }

            }

            prev[j] = flag;
        }

        // indexes usage

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    curr[j] = prev[j - 1];
                } else {
                    if (p.charAt(j - 1) == '*') {
                        curr[j] = prev[j] || curr[j - 1];
                    } else {
                        curr[j] = false;
                    }

                }
            }
            System.arraycopy(curr, 0, prev, 0, m + 1);
        }

        return prev[m];
    }


}
