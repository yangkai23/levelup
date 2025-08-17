package monotonicstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Shanmukha Anirudh
 * @date 17/08/25
 */
public class NextGreaterElementII {
    public static int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length];
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peek() <= nums[i % nums.length])
                deque.pop();
            if (i < nums.length) {
                result[i] = (deque.isEmpty()) ? -1 : deque.peek();
            }
            deque.push(nums[i % nums.length]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(nextGreaterElements(nums1)));
    }
}
