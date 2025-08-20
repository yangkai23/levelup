package monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Shanmukha Anirudh
 * @date 20/08/25
 */
public class SumOfSubarrayRanges {
    public static long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMins(nums);

    }

    public static void main(String[] args) {
        int[] nums = {4,-2,-3,4,1};
        System.out.println(subArrayRanges(nums));
    }

    public static int sumSubarrayMins(int[] arr) {

        int[] nse = nse(arr);
        int[] psee = psee(arr);
        long total = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;
            total = (total + ((long) left * right * arr[i]) % 1000000007) % 1000000007;
        }
        return (int) total;
    }

    public static int sumSubarrayMax(int[] arr) {

        int[] nge = nge(arr);
        int[] pgee = pge(arr);
        long total = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = i - pgee[i];
            int right = nge[i] - i;
            total = (total + ((long) left * right * arr[i]) % 1000000007) % 1000000007;
        }
        return (int) total;
    }

    private static int[] pge(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peek()] < nums[i])
                deque.pop();
            result[i] = (deque.isEmpty()) ? -1 : deque.peek();
            deque.push(i);
        }
        return result;
    }

    private static int[] nge(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[deque.peek()] <= nums[i])
                deque.pop();
            result[i] = (deque.isEmpty()) ? nums.length : deque.peek();
            deque.push(i);
        }
        return result;
    }

    private static int[] nse(int[] ar) {
        int[] result = new int[ar.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = ar.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && ar[stack.peek()] >= ar[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? ar.length : stack.peek();
            stack.push(i);
        }

        return result;
    }

    private static int[] psee(int[] ar) {
        int[] result = new int[ar.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < ar.length; i++) {
            while (!stack.isEmpty() && ar[stack.peek()] > ar[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return result;
    }
}
