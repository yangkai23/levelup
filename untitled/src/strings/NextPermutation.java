package strings;

/**
 * @author Anirudh
 * @since 25/10/25
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {5,4,7,5,3,2};
        nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums) {
        int breakingPoint = -1;
        int n = nums.length;
        boolean descending = false;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakingPoint = i;
                break;
            }
        }
        int windowIndex = -1;
        if (breakingPoint == -1) {
            breakingPoint = 0;
            descending = true;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[breakingPoint]) {
                windowIndex = i;
                break;
            }
        }
        if (windowIndex == -1)
            windowIndex = n - 1;
        if (!descending)
            swap(nums, breakingPoint, windowIndex);

        reverse(nums, descending?breakingPoint: breakingPoint+ 1, windowIndex);

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        int backIndexSupport = 0;
        for (int i = start; i < (nums.length+start) / 2; i++) {
            swap(nums, i, nums.length - backIndexSupport++ - 1);
        }
    }
}
