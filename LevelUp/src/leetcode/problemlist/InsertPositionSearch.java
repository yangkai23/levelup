package leetcode.problemlist;


public class InsertPositionSearch {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        return search(nums, target, 0, nums.length - 1);
    }

    private static int search(int[] nums, int target, int i, int j) {
        int mid = i + (j - i) / 2;
        if (j >= i) {
            int midIndexValue = nums[mid];
            if (midIndexValue == target) return mid;
            else if (target > midIndexValue) return search(nums, target, mid + 1, j);
            else return search(nums, target, i, mid - 1);
        }
        return i;
    }


}
