package monotonicstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Shanmukha Anirudh
 * @date 18/08/25
 */
public class PreviousSmallerElement {
    public static int[] previousSmallerElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,9,6,7};
        System.out.println(Arrays.toString(previousSmallerElements(arr)));
    }
}
