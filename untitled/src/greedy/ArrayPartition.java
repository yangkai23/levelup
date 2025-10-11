package greedy;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 07/10/25
 */
public class ArrayPartition {
    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        System.out.println(arrayPairSum(nums));
    }

    public static int arrayPairSum(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int result = 0;
        for (int i = 1; i < nums.length; i = i + 2) {
            result += nums[i];
        }
        return result;
    }
}
