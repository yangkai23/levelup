package slidingwindow;

/**
 * @author Shanmukha Anirudh
 * @date 16/07/25
 */
public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        System.out.println(numSubarraysWithSum(nums, 2));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return (numSubarraysWithSum1(nums, goal) - numSubarraysWithSum1(nums, goal - 1));
    }

    public static int numSubarraysWithSum1(int[] nums, int goal) {
        if (goal < 0)
            return 0;
        if (nums == null || nums.length == 0)
            return -1;
        int sum = 0;
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}
