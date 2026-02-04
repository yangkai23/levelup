package arrays;

/**
 * @author Anirudh
 * @since 27/01/26
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = nums[0];
        for (int val : nums) {
            sum += val;

            ans = Math.max(sum, ans);

            sum = Math.max(sum, 0);
        }
        return ans;
    }
}
