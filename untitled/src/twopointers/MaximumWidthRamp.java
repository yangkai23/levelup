package twopointers;

public class MaximumWidthRamp {
    public static void main(String[] args) {
        int[] nums = {9,8,1,0,1,9,4,0,4,1};
        System.out.println(maxWidthRamp(nums));
    }

    public static int maxWidthRamp(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return 0;
        int left = 0;
        int right = 1;
        int maxWindow = Integer.MIN_VALUE;
        while (right < nums.length) {
            while (left < right && nums[right] < nums[left]) {
                left++;
            }
            if (nums[left] <= nums[right])
                maxWindow = Math.max(maxWindow, right - left );
            right++;
        }
        return maxWindow;
    }
}
