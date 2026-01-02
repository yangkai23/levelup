package dynamicprogramming;

/**
 * @author Anirudh
 * @since 01/01/26
 */
public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa"));
    }

    public static String shortestCommonSupersequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = n1, j = n2;

        StringBuilder ans = new StringBuilder();
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                ans.append(text2.charAt(j - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(text1.charAt(i - 1));
                i--;
            } else {
                ans.append(text2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            ans.append(text1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            ans.append(text2.charAt(j - 1));
            j--;
        }


        return ans.reverse().toString();

    }
}
