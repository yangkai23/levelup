package slidingwindow;

/**
 * @author Shanmukha Anirudh
 * @date 17/07/25
 */
public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        System.out.println(numberOfSubarrays(nums, 3));
    }

    /**
     *
     *
     * the problem is to find how many odd nums in subarray
     * so if elements are 0 s and 1 s w.r.t even and odd respectively,
     * then it'll become a binary subarray sum
     */
    public static int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2;
        }
        return numberOfSubarrays1(nums, k) - numberOfSubarrays1(nums, k - 1);
    }

    public static int numberOfSubarrays1(int[] nums, int k) {
        if (k < 0)
            return 0;
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum > k) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;

            right++;
        }
        return count;
    }
}
