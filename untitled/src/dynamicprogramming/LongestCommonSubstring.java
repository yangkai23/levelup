package dynamicprogramming;

/**
 * @author Anirudh
 * @since 01/01/26
 */
public class LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(longestCommonSubstr("YZ", "yz"));
    }

    public static int longestCommonSubstr(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];
            int ans=0;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans=Math.max(ans, dp[i][j]);
                }

            }
        }
        return ans;

    }
}
