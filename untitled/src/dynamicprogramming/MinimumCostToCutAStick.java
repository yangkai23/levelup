package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 05/01/26
 */
public class MinimumCostToCutAStick {
    public static void main(String[] args) {
        int[] cuts = {1, 3, 4, 5};
        System.out.println(minCost(7, cuts));
    }

    public static int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] temp = new int[m + 2];
        System.arraycopy(cuts, 0, temp, 1, m);

        temp[0] = 0;
        temp[temp.length - 1] = n;
        Arrays.sort(temp);
        int[][] dp = new int[m + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fn(1, m, temp, dp);
    }

    static int fn(int i, int j, int[] cuts, int[][] dp) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int steps = cuts[j + 1] - cuts[i - 1] + fn(i, k - 1, cuts, dp) + fn(k + 1, j, cuts, dp);
            min = Math.min(steps, min);
        }
        dp[i][j] = min;

        return min;
    }
}
