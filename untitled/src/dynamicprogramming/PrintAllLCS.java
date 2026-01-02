package dynamicprogramming;

import java.util.*;

/**
 * @author Anirudh
 * @since 31/12/25
 */
public class PrintAllLCS {
    static Map<String, Set<String>> memo = new HashMap<>();

    public static List<String> allLCS(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = buildDP(s1, s2);

        Set<String> res = dfs(s1, s2, n, m, dp);
        List<String> ans = new ArrayList<>(res);
        Collections.sort(ans);
        return ans;
    }

    private static int[][] buildDP(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp;
    }

    private static Set<String> dfs(
            String s1, String s2, int i, int j, int[][] dp) {

        String key = i + "|" + j;
        if (memo.containsKey(key))
            return memo.get(key);

        Set<String> res = new HashSet<>();

        if (i == 0 || j == 0) {
            res.add("");
        } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            for (String str : dfs(s1, s2, i - 1, j - 1, dp)) {
                res.add(str + s1.charAt(i - 1));
            }
        } else {
            if (dp[i - 1][j] >= dp[i][j - 1])
                res.addAll(dfs(s1, s2, i - 1, j, dp));

            if (dp[i][j - 1] >= dp[i - 1][j])
                res.addAll(dfs(s1, s2, i, j - 1, dp));
        }

        memo.put(key, res);
        return res;
    }
}
