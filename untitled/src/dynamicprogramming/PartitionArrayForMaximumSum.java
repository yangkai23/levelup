package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 06/01/26
 */
public class PartitionArrayForMaximumSum {
    public static int maxSumAfterPartitioning(int[] arr, int k) {

        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return fn(0, k, n, arr, dp);
    }

    static int fn(int i, int k, int n, int[] arr, int[] dp) {
        if (i == n)
            return 0;

        if (dp[i] != -1)
            return dp[i];
        int len = 0;
        int maxNum = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;

        for (int j = i; j < Math.min(i + k, n); j++) {
            len++;
            maxNum = Math.max(maxNum, arr[j]);

            int sum = len * maxNum + fn(j + 1, k, n, arr, dp);

            ans = Math.max(ans, sum);
        }
        dp[i] = ans;
        return ans;
    }

    public static int maxSumAfterPartitioningUsingTabulation(int[] arr, int k) {

        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int len = 0;
            int maxNum = Integer.MIN_VALUE;
            int ans = Integer.MIN_VALUE;

            for (int j = i; j < Math.min(i + k, n); j++) {
                len++;
                maxNum = Math.max(maxNum, arr[j]);

                int sum = len * maxNum + dp[j + 1];

                ans = Math.max(ans, sum);
            }
            dp[i] = ans;
        }
        return dp[0];
    }
}
