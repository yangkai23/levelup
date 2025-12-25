package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 23/12/25
 */
public class NinjasTraining {
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][4];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return trainUsingMemoization(matrix, n - 1, 3, dp);
    }

    private int trainUsingMemoization(int[][] matrix, int day, int lastTask, int[][] dp) {
        if (day == 0) {
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < 3; i++) {
                if (i != lastTask) {
                    max = Math.max(max, matrix[0][i]);
                }
            }
            dp[0][lastTask] = max;
            return max;
        }

        if (dp[day][lastTask] != -1) return dp[day][lastTask];
        int maxPoints = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != lastTask) {
                int points = matrix[day][i] + trainUsingMemoization(matrix, day - 1, i, dp);
                maxPoints = Math.max(maxPoints, points);
            }
        }
        dp[day][lastTask] = maxPoints;
        return maxPoints;
    }

    private int trainUsingTabulation(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(matrix[0][1], matrix[0][2]);
        dp[0][1] = Math.max(matrix[0][0], matrix[0][2]);
        dp[0][2] = Math.max(matrix[0][0], matrix[0][1]);
        dp[0][3] = Math.max(matrix[0][0], Math.max(matrix[0][1], matrix[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                int max = Integer.MIN_VALUE;
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int points = matrix[day][task] + dp[day - 1][task];
                        max = Math.max(max, points);
                        dp[day][last] = max;
                    }

                }
            }

        }

        return dp[n - 1][3];
    }
}
