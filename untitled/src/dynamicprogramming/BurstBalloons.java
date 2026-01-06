package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 05/01/26
 */
public class BurstBalloons {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        System.out.println(maxCoins(nums));
    }

    public static int maxCoins(int[] nums) {

        int n = nums.length;

        int[] arr = new int[n + 2];
        System.arraycopy(nums, 0, arr, 1, n);
        arr[0] = 1;
        arr[n + 1] = 1;

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fn(1, n, arr, dp);


    }

    static int fn(int i, int j, int[] nums, int[][] dp) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int coins = nums[k] * nums[i - 1] * nums[j + 1] + fn(i, k - 1, nums, dp) + fn(k + 1, j, nums, dp);
            max = Math.max(max, coins);
        }
        dp[i][j] = max;
        return max;
    }

    public static int maxCoinsUsingTabulation(int[] nums) {

        int n = nums.length;

        int[] arr = new int[n + 2];
        System.arraycopy(nums, 0, arr, 1, n);
        arr[0] = 1;
        arr[n + 1] = 1;

        int[][] dp = new int[n + 2][n + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j)
                    continue;
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int coins = arr[k] * arr[i - 1] * arr[j + 1] + dp[i][k - 1] + dp[k + 1][j];
                    max = Math.max(max, coins);
                }
                dp[i][j] = max;
            }
        }

        return dp[1][n];

    }
}
