package binarysearch;

/**
 * @author Anirudh
 * @since 13/10/25
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {11, 13, 15, 17};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int min = 5001;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[low] <= nums[mid]) {
                min = Math.min(nums[low], min);
                low = mid + 1;
            } else {
                min = Math.min(nums[mid], min);
                high = mid - 1;
            }

        }
        return min;

    }
}
