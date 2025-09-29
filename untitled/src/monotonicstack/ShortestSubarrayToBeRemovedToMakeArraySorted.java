package monotonicstack;

public class ShortestSubarrayToBeRemovedToMakeArraySorted {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 10, 4, 2, 3, 5};
        System.out.println(findLengthOfShortestSubarray(nums));
    }

    public static int findLengthOfShortestSubarray(int[] nums) {
        int n = nums.length;
        int right = n - 1;

        while (right > 0 && nums[right - 1] <= nums[right]) {
            right--;
        }
        if (right == 0) return 0;
        int left = 0;
        while (left + 1 < n && nums[left] <= nums[left + 1]) {
            left++;
        }
        int res = Math.min(n - left - 1, right);

        int i = 0, j = right;
        while (i <= left && j < n) {
            if (nums[i] <= nums[j]) {
                res = Math.min(res, j - i - 1);
                i++;
            } else
                j++;
        }
        return res;
    }
}
