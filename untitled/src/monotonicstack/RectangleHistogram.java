package monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Shanmukha Anirudh
 * @date 22/08/25
 */
public class RectangleHistogram {
    /**
     * Computes the largest rectangular area in a histogram given an array of bar heights.
     * The method uses a monotonic stack to efficiently calculate the maximum area.
     *
     * @param heights an array of integers where each integer represents the height of a bar in the histogram
     * @return the area of the largest rectangle that can be formed in the histogram
     */
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {

                int element = stack.pop();
                int pse = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, (i - pse - 1) * heights[element]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int nse = heights.length;
            int element = stack.pop();
            int pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, (nse - pse - 1) * heights[element]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 4};
        System.out.println(largestRectangleArea(heights));
    }
}
