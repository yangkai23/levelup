package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 28/12/25
 */
public class SubsetSumProblem {
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;

        int[][] dp = new int[n][sum + 1];
        /*
         * Why boolean dp breaks memoization:
         * false can mean two things:
         * “Not computed yet”
         * “Computed and result is false”
         * You cannot distinguish between these two with a boolean DP
         * You need three states: uncomputed / true / false.
         * Best options:
         * Use Boolean[][] dp (wrapper type, default null)
         * Or use an int[][] dp with -1, 0, 1
         */
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return findSum(arr, n - 1, sum);
    }

    static boolean findSum(int[] arr, int n, int target) {
        if (target == 0)
            return true;
        if (n == 0) {
            return arr[0] == target;
        }

        boolean notTake = findSum(arr, n - 1, target);

        boolean take = false;

        if (target >= arr[n]) {
            take = findSum(arr, n - 1, target - arr[n]);
        }

        return take || notTake;
    }

    static boolean findSumUsingMemoization(int[] arr, int n, int target, int[][] dp) {
        if (target == 0)
            return true;
        if (n == 0) {
            return arr[0] == target;
        }

        if (dp[n][target] == 1)
            return true;
        boolean notTake = findSumUsingMemoization(arr, n - 1, target, dp);

        boolean take = false;

        if (target >= arr[n]) {
            take = findSumUsingMemoization(arr, n - 1, target - arr[n], dp);
        }

        dp[n][target] = take || notTake == false ? 0 : 1;

        return take || notTake;
    }

    static boolean findSumUsingTabulation(int[] arr, int k) {
        int n = arr.length;
        // here we can use boolean arr because we don't have an unvisited case here
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

        return dp[n - 1][k];


    }

    static boolean findSumUsingTabulationWithSpaceOptimization(int[] arr, int k) {
        int n = arr.length;
        // here we can use boolean arr because we don't have an unvisited case here
        boolean[] curr = new boolean[k + 1];
        boolean[] prev = new boolean[k + 1];

        curr[0] = true;
        prev[0] = true;

        if (arr[0] <= k)
            prev[arr[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= k; target++) {
                boolean notTake = prev[target];

                boolean take = false;

                if (target >= arr[i]) {
                    take = prev[target - arr[i]];
                }


                curr[target] = (take || notTake);

            }
            System.arraycopy(curr, 0, prev, 0, k + 1);
        }

        return prev[k];


    }
}
