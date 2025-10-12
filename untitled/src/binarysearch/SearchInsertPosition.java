package binarysearch;

/**
 * @author Anirudh
 * @since 12/10/25
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int pos = nums.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                pos = mid;
                break;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                pos = mid;
                high = mid - 1;
            }
        }
        return pos;
    }
}
