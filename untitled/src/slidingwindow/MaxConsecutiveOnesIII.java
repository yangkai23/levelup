package slidingwindow;

/**
 * @author shanmukhaanirudhtalluri
 * @date 01/07/25
 */
public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(longestOnes(nums, 2));
    }

    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int zeroCount = 0;
        while (right < nums.length) {
            if (nums[right] == 0) zeroCount++;
            if (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            if (zeroCount <= k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
        return maxLength;
    }
}
