package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Anirudh
 * @since 28/12/25
 */
public class PartitionArrayIntoTwoArraysToMinimizeSumDifference {
    public static void main(String[] args) {
        int[] nums = {2, -1, 0, 4, -2, -9};

        System.out.println(minimumDifference(nums));
    }

    public static int minimumDifference(int[] nums) {
        //Meet in the middle algorithm
        int n = nums.length;
        int half = n / 2;

        int totalSum = 0;
        for (int v : nums) totalSum += v;

        // split array
        int[] left = Arrays.copyOfRange(nums, 0, half);
        int[] right = Arrays.copyOfRange(nums, half, n);

        // leftSums[k] = all sums using k elements from left
        // rightSums[k] = all sums using k elements from right
        List<Integer>[] leftSums = new ArrayList[half + 1];
        List<Integer>[] rightSums = new ArrayList[half + 1];

        for (int i = 0; i <= half; i++) {
            leftSums[i] = new ArrayList<>();
            rightSums[i] = new ArrayList<>();
        }

        // generate subset sums
        generateSums(left, 0, 0, 0, leftSums);
        generateSums(right, 0, 0, 0, rightSums);

        // sort right side for binary search
        for (int i = 0; i <= half; i++) {
            Collections.sort(rightSums[i]);
        }

        int ans = Integer.MAX_VALUE;

        // meet in the middle
        for (int k = 0; k <= half; k++) {
            List<Integer> L = leftSums[k];
            List<Integer> R = rightSums[half - k];

            for (int sumL : L) {
                int target = (totalSum / 2) - sumL;

                int idx = Collections.binarySearch(R, target);
                if (idx < 0) idx = -idx - 1; // insertion point

                // check closest right sums
                if (idx < R.size()) {
                    int sum = sumL + R.get(idx);
                    ans = Math.min(ans, Math.abs(totalSum - 2 * sum));
                }
                if (idx > 0) {
                    int sum = sumL + R.get(idx - 1);
                    ans = Math.min(ans, Math.abs(totalSum - 2 * sum));
                }
            }
        }

        return ans;
    }

    private static void generateSums(
            int[] arr,
            int idx,
            int count,
            int sum,
            List<Integer>[] sums) {

        if (idx == arr.length) {
            sums[count].add(sum);
            return;
        }

        // not take
        generateSums(arr, idx + 1, count, sum, sums);

        // take
        generateSums(arr, idx + 1, count + 1, sum + arr[idx], sums);
    }
}
