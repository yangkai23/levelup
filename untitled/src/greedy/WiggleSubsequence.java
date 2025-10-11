package greedy;

/**
 * @author Anirudh
 * @since 06/10/25
 */
public class WiggleSubsequence {
    public static int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return n;

        int prevDiff = nums[1] - nums[0];
        int count = prevDiff != 0 ? 2 : 1;

        for (int i = 2; i < n; i++) {
            int currDiff = nums[i] - nums[i - 1];

            if ((currDiff > 0 && prevDiff <= 0) || (currDiff < 0 && prevDiff >= 0)) {
                count++;
                prevDiff = currDiff;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(wiggleMaxLength(nums));
    }
}
