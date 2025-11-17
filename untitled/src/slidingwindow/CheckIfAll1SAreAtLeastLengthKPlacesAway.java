package slidingwindow;

/**
 * @author Anirudh
 * @since 17/11/25
 */
public class CheckIfAll1SAreAtLeastLengthKPlacesAway {
    public static void main(String[] args) {
        int[] nums={0,0,0};
        System.out.println(kLengthApart(nums,2));
    }
    public static boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int lastSeenOne = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                lastSeenOne = i;
                break;
            }

        }
        if (lastSeenOne == -1) {
            return false;
        }
        for (int i = lastSeenOne + 1; i < n; i++) {
            if (nums[i] == 1) {
                if ((i - lastSeenOne - 1) < k)
                    return false;
                lastSeenOne=i;
            }
        }
        return true;
    }
}
