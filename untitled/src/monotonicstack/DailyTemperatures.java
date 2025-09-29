package monotonicstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Shanmukha Anirudh
 * @date 05/09/25
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] nge = nextLargerElement(temperatures);
        int[] result = new int[temperatures.length];
        for (int i = 0; i < nge.length; i++) {
            result[i] = nge[i] == temperatures.length ? 0 : nge[i] - i;
        }
        return result;
    }

    private static int[] nextLargerElement(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? nums.length : stack.peek();
            stack.push(i);

        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}
