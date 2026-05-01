package twopointers;

/**
 * @author Anirudh
 * @since 06/02/26
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;

        int max = 0;
        int ones = 0;
        int zeroes = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] == 1) {
                ones++;
            } else {
                zeroes++;
            }

            if (zeroes > 0) {
                if (nums[left] == 0)
                    zeroes--;
                else
                    ones--;

                left++;
            }

            if (zeroes == 0) {
                max = Math.max(ones, max);
            }
            right++;
        }
        return max;
    }
}
