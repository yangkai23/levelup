package slidingwindow;

/**
 * @author Shanmukha Anirudh
 * @date 24/08/25
 */
public class LongestSubarrayOf1sAfterDeletingOneElement {
    public static int longestSubarray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int zeros = 0;
        int max = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeros++;
            while (zeros > 1) {
                if (nums[left] == 0) zeros--;
                left++;
            }
            max = Math.max(max, right - left + 1 - 1);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0,0,0};
        System.out.println(longestSubarray(nums));
    }
}
