package prefixsuffix;

/**
 * @author Shanmukha Anirudh
 * @date 07/09/25
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(heights));
    }

    public static int trap(int[] height) {
        /*int[] prefix = new int[height.length];
        prefix[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            prefix[i] = Math.max(height[i], prefix[i - 1]);
        }
        int[] suffix = new int[height.length];
        suffix[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            suffix[i] = Math.max(height[i], suffix[i + 1]);
        }
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = prefix[i];
            int rightMax = suffix[i];
            if (height[i] < leftMax && height[i] < rightMax) {
                total += Math.min(leftMax, rightMax) - height[i];
            }
        }
        return total;*/

        int leftMax = 0;
        int rightMax = 0;
        int total = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (leftMax > height[left]) {
                    total += leftMax - height[left];
                } else
                    leftMax = height[left];
                left++;
            } else {
                if (rightMax > height[right]) {
                    total += rightMax - height[right];
                } else
                    rightMax = height[right];
                right--;
            }

        }
        return total;
    }
}
