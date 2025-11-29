package binarysearch;

/**
 * @author Anirudh
 * @since 25/11/25
 */
public class CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(check(nums));
    }

    public static boolean check(int[] nums) {
        int n = nums.length;
        boolean rotated = false;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                if (rotated) return false;
                rotated = true;
            }
        }
        if (rotated) {
            return nums[0] >= nums[n - 1];
        } else return true;
    }
}
