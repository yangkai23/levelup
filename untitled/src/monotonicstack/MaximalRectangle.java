package monotonicstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Shanmukha Anirudh
 * @date 23/08/25
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {{'1'}};
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        int[][] prefix = calculatePrefix(matrix);
        int maxArea = 0;
        for (int[] row : prefix) {
            maxArea = Math.max(maxArea, largestRectangleArea(row));
        }
        return maxArea;
    }

    private static int[][] calculatePrefix(char[][] matrix) {
        int[][] prefix = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < matrix.length; i++) {
                sum += matrix[i][j] - '0';
                if (matrix[i][j] == '0')
                    sum = 0;
                prefix[i][j] = sum;
            }
        }
        return prefix;
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {

                int element = stack.pop();
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int nse=i;
                maxArea = Math.max(maxArea, (nse - pse - 1) * heights[element]);
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

}
