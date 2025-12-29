package dynamicprogramming;

/**
 * @author Anirudh
 * @since 28/12/25
 */
public class MinimumSumPartition {
    public int minDifference(int[] arr) {
        int n = arr.length;
        int totalSum = 0;
        for (int v : arr) totalSum += v;

        int k = totalSum;

        // subset sum equal to target tabulation code

        boolean[][] dp = new boolean[n][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= k; target++) {
                boolean notTake = dp[i - 1][target];

                boolean take = false;

                if (target >= arr[i]) {
                    take = dp[i - 1][target - arr[i]];
                }


                dp[i][target] = (take || notTake);

            }
        }

        //check dp n-1 arr for attainable targets
        int ans = (int) 1e9;
        for (int i = 0; i <= (k + 1) / 2; i++) {
            if (dp[n - 1][i]) {
                ans = Math.min(ans, Math.abs(i - (totalSum - i)));
            }
        }
        return ans;
    }
}
