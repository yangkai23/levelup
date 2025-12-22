package dynamicprogramming;

import java.util.*;

/**
 * @author Anirudh
 * @since 22/12/25
 */
public class FrogJumpWithKJumps {
    public static void main(String[] args) {
        int[] height = {};
    }

    static int minCost(int[] height) {
        int n = height.length;
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return jumpWithKStopsUsingMemoization(n - 1, height, 3, dp);
    }

    private static int jumpWithKStops(int n, int[] height, int k) {
        if (n == 0) return 0;
        int minJumps = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            if ((n - i) >= 0) {
                int jumps = jumpWithKStops(n - i, height, k) + Math.abs(height[n] - height[n - i]);
                minJumps = Math.min(minJumps, jumps);
            }

        }
        return minJumps;
    }

    private static int jumpWithKStopsUsingMemoization(int n, int[] height, int k, int[] dp) {
        if (n == 0) return 0;
        int minJumps = Integer.MAX_VALUE;
        if (dp[n] != -1) return dp[n];
        for (int i = 1; i <= k; i++) {
            if ((n - i) >= 0) {
                int jumps = jumpWithKStopsUsingMemoization(n - i, height, k, dp) + Math.abs(height[n] - height[n - i]);
                minJumps = Math.min(minJumps, jumps);
            }

        }
        dp[n] = minJumps;
        return dp[n];
    }

    private static int jumpWithKStopsUsingTabulation(int n, int[] height, int k) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int idx = 1; idx < n; idx++) {

            int jumps = Integer.MAX_VALUE;
            for (int i = 1; i <= k; i++) {
                if ((idx - i) >= 0) {
                    int cost = dp[idx - i] + Math.abs(height[idx] - height[idx - i]);
                    jumps = Math.min(jumps, cost);
                }

            }
            dp[idx] = jumps;

        }

        return dp[n - 1];
    }

    /**
     * Computes the minimum energy required for the frog to reach the last stone
     * when it can jump at most {@code k} stones at a time.
     *
     * <p>This is a space-optimized bottom-up dynamic programming solution.
     * Instead of storing DP values for all stones, it maintains a sliding window
     * of the last {@code k} DP values using a deque.</p>
     *
     * <p>DP definition:
     * <ul>
     *   <li>{@code dp[i]} = minimum energy required to reach stone {@code i}</li>
     * </ul>
     * <p>
     * Transition:
     * <pre>
     * dp[i] = min(dp[i - j] + |height[i] - height[i - j]|) for j = 1..k
     * </pre>
     * <p>
     * Space Optimization:
     * <ul>
     *   <li>Only the last {@code k} DP values are needed at any time</li>
     *   <li>Older values are discarded as they will never be used again</li>
     * </ul>
     *
     * @param n      total number of stones
     * @param height array where {@code height[i]} represents the height of stone {@code i}
     * @param k      the maximum number of stones the frog can jump
     * @return minimum energy required to reach the last stone
     * <p>
     * Time Complexity: O(n × k) <br>
     * Space Complexity: O(k)
     */
    private static int jumpWithKStopsUsingTabulationWithK_DPSizeArr(
            int n, int[] height, int k) {

        Deque<Integer> dp = new ArrayDeque<>();
        dp.addLast(0); // dp[0] = 0

        for (int idx = 1; idx < n; idx++) {
            int minCost = Integer.MAX_VALUE;
            int j = 1;

            // Iterate over the last k DP values (sliding window)
            for (int prevCost : dp) {
                int cost =
                        prevCost + Math.abs(height[idx] - height[idx - j]);
                minCost = Math.min(minCost, cost);
                j++;
                if (j > k) break;
            }

            // Maintain window size of k
            if (dp.size() == k) {
                dp.removeFirst();
            }
            dp.addLast(minCost);
        }

        return dp.peekLast();
    }

}
