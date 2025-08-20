package monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Shanmukha Anirudh
 * @date 20/08/25
 */
public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));
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
