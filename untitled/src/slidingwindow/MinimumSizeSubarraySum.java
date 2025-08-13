package slidingwindow;

/**
 * @author Shanmukha Anirudh
 * @date 06/08/25
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
