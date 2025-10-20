package binarysearch;

/**
 * @author Anirudh
 * @since 19/10/25
 */
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {1,4,4};
        System.out.println(splitArray(nums, 3));
    }

    public static int splitArray(int[] nums, int k) {
        long low = 0;
        long high = 0;
        for (int val : nums) {
            high += val;
            low = Math.max(low, val);
        }
        long result = -1;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (canBeSplit(nums, k, mid)) {

                high = mid - 1;
                result = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int) result;
    }

    public static boolean canBeSplit(int[] nums, int k, long target) {
        int count = 1;
        long sum = 0;
        for (int num : nums) {
            if (sum + num > target) {
                sum = num;
                count++;
            } else {
                sum += num;
            }
        }
        return count <= k;
    }
}
