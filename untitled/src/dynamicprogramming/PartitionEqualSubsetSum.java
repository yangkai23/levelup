package dynamicprogramming;

/**
 * @author Anirudh
 * @since 28/12/25
 */
public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        if (sum % 2 == 1)
            return false;
        int target = sum / 2;
        return findSumUsingTabulationWithSpaceOptimization(arr, target);


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
