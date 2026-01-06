package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anirudh
 * @since 03/01/26
 */
public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fn(n, 0, 0, nums, dp);
    }

    static int fn(int n, int idx, int prevIdx, int[] nums, int[][] dp) {
        if (idx == n)
            return 0;


        if (dp[idx][prevIdx] != -1)
            return dp[idx][prevIdx];
        // notTake
        int notTake = fn(n, idx + 1, prevIdx, nums, dp);

        //take
        int take = 0;

        if (prevIdx == 0 || nums[idx] > nums[prevIdx - 1]) {
            take = 1 + fn(n, idx + 1, idx + 1, nums, dp);
        }
        dp[idx][prevIdx] = Math.max(notTake, take);
        return dp[idx][prevIdx];
    }

    public static int lengthOfLISUsingTabulation(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                // notTake
                int notTake = dp[i + 1][j + 1];
                //take
                int take = 0;

                if (j == -1 || nums[i] > nums[j]) {
                    take = 1 + dp[i + 1][i + 1];
                }
                dp[i][j + 1] = Math.max(notTake, take);
            }
        }
        return dp[0][-1 + 1];

    }

    public static int lengthOfLISUsingTabulationWithSpaceOptimization(int[] nums) {

        int n = nums.length;
        int[] curr = new int[n + 1];
        int[] next = new int[n + 1];


        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                // notTake
                int notTake = next[j + 1];
                //take
                int take = 0;

                if (j == -1 || nums[i] > nums[j]) {
                    take = 1 + next[i + 1];
                }
                curr[j + 1] = Math.max(notTake, take);
            }
            System.arraycopy(curr, 0, next, 0, n + 1);
        }
        return next[-1 + 1];

    }

    public static int lengthOfLIS1dDpAlgo(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i])
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
            }
            max = Math.max(max, dp[i]);
        }

        return max;


    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 8, 4, 5, 6, -1, 9};
        System.out.println(lengthOfLISBinarySearch(nums));
    }

    public static int lengthOfLISBinarySearch(int[] nums) {

        int n = nums.length;
        List<Integer> seq = new ArrayList<>();
        seq.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > seq.getLast())
                seq.add(nums[i]);
            else {
                int low = 0;
                int high = seq.size()-1;
                while (low <= high) {
                    int mid = (low + high) / 2;

                    if (seq.get(mid) < nums[i])
                        low = mid + 1;
                    else
                        high = mid - 1;
                }

                seq.set(low, nums[i]);
            }
        }

        return seq.size();


    }

}
