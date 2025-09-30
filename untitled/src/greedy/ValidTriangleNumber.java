package greedy;

import java.util.Arrays;

public class ValidTriangleNumber {
    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i > 1; i--) {
            int right = i - 1;
            int left = 0;
            while (right > left) {
                if (nums[right] + nums[left] > nums[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums={1,2,1,10};
        System.out.println(triangleNumber(nums));
    }
}
