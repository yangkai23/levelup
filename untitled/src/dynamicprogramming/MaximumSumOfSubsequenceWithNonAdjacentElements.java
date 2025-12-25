package dynamicprogramming;

/**
 * @author Anirudh
 * @since 23/12/25
 */
public class MaximumSumOfSubsequenceWithNonAdjacentElements {
    public static void main(String[] args) {
        int[] nums = {0, -1};
        int[][] queries = {{0, -5}};
        System.out.println(maximumSumSubsequence(nums, queries));
    }

    public static int maximumSumSubsequence(int[] nums, int[][] queries) {
        int n = nums.length;
        int res = 0;
        for (int[] q : queries) {
            nums[q[0]] = q[1];
            res += findSumUsingTabulationSpaceOptimization(n, nums);
        }
        return res;
    }

    private static int findSumUsingTabulationSpaceOptimization(int n, int[] nums) {

        int prev = nums[0];
        int prev2 = 0;


        for (int i = 1; i < n; i++) {
            int take = nums[i];
            if (i > 1 && prev2 > 0) take += prev2;
            int notTake = prev;
            int curr = Math.max(take, notTake);

            prev2 = prev;
            prev = curr;
        }
        return Math.max(prev, 0);

    }
}
