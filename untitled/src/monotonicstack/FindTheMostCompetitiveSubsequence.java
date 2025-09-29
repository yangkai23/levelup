package monotonicstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FindTheMostCompetitiveSubsequence {
    public static void main(String[] args) {
        int[] nums = {71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2};
        int k = 3;
        System.out.println(Arrays.toString(mostCompetitive(nums, k)));
    }

    public static int[] mostCompetitive(int[] nums, int k) {
        int[] result = new int[k];
        int top = -1;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (top >= 0 && result[top] > nums[i] && (top + (n - i)) >= k) {
                top--;
            }
            if (top + 1 < k) {
                result[++top] = nums[i];
            }
        }
        return result;
    }
}
