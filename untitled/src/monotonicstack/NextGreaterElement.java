package monotonicstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author Shanmukha Anirudh
 * @date 17/08/25
 */
public class NextGreaterElement {
    public static int[] nextLargerElement(int[] nums1, int[] nums2) {
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums2.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            map.put(nums2[i], i);
            while (!deque.isEmpty() && deque.peek() < nums2[i]) {
                deque.poll();
            }
            if (deque.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = deque.peek();
            }

            deque.push(nums2[i]);
        }
        int[] output = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            output[i] = result[map.get(nums1[i])];
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextLargerElement(nums1, nums2)));
    }
}
