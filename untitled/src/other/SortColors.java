package other;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Anirudh
 * @since 14/01/26
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    // counting approach
    public static void sortColors(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int twos = 0;
        int ones = 0;
        int zeroes = 0;

        for (int num : nums) {
            if (num == 0)
                zeroes++;
            else if (num == 1)
                ones++;
            else
                twos++;
        }
        int k = 0;
        for (int i = 0; i < zeroes; i++) nums[k++] = 0;
        for (int i = 0; i < ones; i++) nums[k++] = 1;
        for (int i = 0; i < twos; i++) nums[k++] = 2;
    }

    public void sortColorsUsingDutchNationalFlag(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int t = nums[low];
                nums[low] = 0;
                nums[mid] = t;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int t = nums[high];
                nums[high] = nums[mid];
                nums[mid] = t;
                high--;
            }
        }
    }
}
