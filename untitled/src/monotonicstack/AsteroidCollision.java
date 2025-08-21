package monotonicstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Shanmukha Anirudh
 * @date 21/08/25
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        int[] ar = {4, 7, 1, 1, 2, -3, -7, 17, 15, -16};
        System.out.println(Arrays.toString(asteroidCollision(ar)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else if (stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                }
            }


        }
        int[] result = new int[stack.size()];
        int i = result.length - 1;
        while (!stack.isEmpty()) {
            result[i--] = stack.pop();
        }
        return result;

    }
}
