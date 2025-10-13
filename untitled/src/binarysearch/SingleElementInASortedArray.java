package binarysearch;

/**
 * @author Anirudh
 * @since 13/10/25
 */
public class SingleElementInASortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
       /* int low = 0;
        int high = nums.length - 1;
        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (low == high) {
                result = nums[low];
                break;
            }
            if (nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 0)
                    high = mid - 2;
                else
                    low = mid + 1;
            } else if (nums[mid] == nums[mid + 1]) {
                if ((nums.length - mid) % 2 == 0)
                    high = mid - 1;
                else
                    low = mid + 1;
            } else
                return nums[mid];
        }
        return result;*/


        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (nums[0] != nums[1])
            return nums[0];
        if (nums[n - 1] != nums[n - 2])
            return nums[n - 1];
        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];

            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return -1;
    }
}
