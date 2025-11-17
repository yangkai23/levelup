package monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Anirudh
 * @since 10/11/25
 */
public class MinimumOperationsToConvertAllElementsToZero {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 1};
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        stack.push(nums[0]);
        int operations = 1;
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < nums[i]) {
                operations++;
                stack.push(nums[i]);
            }

        }
        return operations;
    }
}
