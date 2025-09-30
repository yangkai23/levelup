package greedy;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 29/09/25
 */
public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 10};
        System.out.println(largestPerimeter(nums));
    }

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }
}
