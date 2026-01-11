package dynamicprogramming;

import java.util.HashSet;

/**
 * @author Anirudh
 * @since 10/01/26
 */
public class MinimumASCIIDeleteSumForTwoStrings {
    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("delete", "leet"));
    }

    public static int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        HashSet<Integer> set=new HashSet<>();
        for(int i=1;i<=n;i++){
            dp[i][0]=dp[i-1][0]+s1.charAt(i-1);
        }
        for(int i=1;i<=m;i++){
            dp[0][i]=dp[0][i-1]+s2.charAt(i-1);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(s1.charAt(i - 1) + dp[i - 1][j],
                            s2.charAt(j - 1) + dp[i][j - 1]);
                }
            }
        }



        return dp[n][m];


    }


}
