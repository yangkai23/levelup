package twopointers;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 01/02/26
 */
public class FindTheRepeatingAndMissingNumber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 6, 7, 5, 7};
        System.out.println(Arrays.toString(findMissingRepeatingNumbers(nums)));
    }

    public static int[] findMissingRepeatingNumbers(int[] nums) {

        int n = nums.length;

        int sum = 0;
        int sqSum = 0;

        for (int val : nums) {
            sum += val;
            sqSum += val * val;
        }

        int nSum = (n * (n + 1)) / 2;
        int nSqSum = (n * (n + 1) * (2 * n + 1)) / 6;

        int val1 = nSum - sum;
        int val2 = nSqSum - sqSum;
        val2 = val2 / val1;

        int x = (val1 + val2) / 2;
        int y = x - val1;

        return new int[]{y,x};


    }
}
