package greedy;

/**
 * @author Anirudh
 * @since 06/10/25
 */
public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums = {20, 100, 10, 12, 5, 13};
        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] > secondSmallest)
                return true;
            if (nums[i] < smallest)
                smallest = nums[i];
            else if (nums[i] > smallest && nums[i] < secondSmallest)
                secondSmallest = nums[i];
        }
        return false;
    }
}
