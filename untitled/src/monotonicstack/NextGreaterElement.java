package monotonicstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Shanmukha Anirudh
 * @date 17/08/25
 */
public class NextGreaterElement {
    public static int[] nextLargerElement(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peek() < arr[i]) {
                deque.poll();
            }
            if (deque.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = deque.peek();
            }

            deque.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        System.out.println(Arrays.toString(nextLargerElement(arr)));
    }
}
