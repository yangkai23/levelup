package monotonicstack;


/**
 * @author Shanmukha Anirudh
 * @date 03/09/25
 */
public class ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int right = -1;
        int maxSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxSoFar = Math.max(nums[i], maxSoFar);
            if (nums[i] < maxSoFar) {
                right = i;
            }
        }
        int minSoFar = Integer.MAX_VALUE;
        int left = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            minSoFar = Math.min(nums[i], minSoFar);
            if (nums[i] > minSoFar) {
                left = i;
            }

        }
        if (left == -1) {
            return 0;
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(findUnsortedSubarray(nums));
    }
}
