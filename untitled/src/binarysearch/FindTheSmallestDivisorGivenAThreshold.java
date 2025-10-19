package binarysearch;

/**
 * @author Anirudh
 * @since 17/10/25
 */
public class FindTheSmallestDivisorGivenAThreshold {
    public static void main(String[] args) {
        int[] nums = {44, 22, 33, 11, 1};
        System.out.println(smallestDivisor(nums, 6));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        long low = 1;
        long high = Integer.MIN_VALUE;

        for (int val : nums) {
            low = Math.min(val, low);
            high = Math.max(val, high);
        }
        long result = -1;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (getSum(nums, mid, threshold)) {
                result = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return (int) result;
    }

    private static boolean getSum(int[] nums, long divisor, int threshold) {
        long sum = 0;
        for (int val : nums) {
            sum += Math.ceilDiv(val, divisor);
        }
        return sum <= threshold;
    }
}
