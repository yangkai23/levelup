package dynamicprogramming;

/**
 * @author Anirudh
 * @since 05/01/26
 */
public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(matrixMultiplication(arr));
    }

    static int matrixMultiplication(int[] arr) {

        int n = arr.length;
        int i = 1;
        int j = n - 1;
        return fn(i, j, arr);
    }

    private static int fn(int i, int j, int[] arr) {
        if (i == j)
            return 0;

        int min = (int) 1e9;

        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j] + fn(i, k, arr) + fn(k + 1, j, arr);
            min = Math.min(steps, min);
        }

        return min;
    }

    static int matrixMultiplicationUsingTabulation(int[] arr) {

        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }


        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int min = (int) 1e9;
                for (int k = i; k < j; k++) {
                    int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
                    min = Math.min(steps, min);
                }
                dp[i][j] = min;
            }
        }


        return dp[1][n - 1];
    }
}
