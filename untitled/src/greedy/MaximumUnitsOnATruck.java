package greedy;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 01/10/25
 */
// Fractional knapsack
public class MaximumUnitsOnATruck {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int result = 0;
        for (int[] ar : boxTypes) {
            int count = Math.min(truckSize, ar[0]);
            result += count * ar[1];
            truckSize -= count;
            if (truckSize == 0)
                break;
        }
        return result;
    }

    public double fractionalKnapsack(int[][] items, int capacity) {
        Arrays.sort(items, (a, b) -> Double.compare((double) b[0] / b[1], (double) a[0] / a[1]));

        double result = 0.0;

        for (int i = 0; i < items.length && capacity > 0; i++) {
            if (items[i][1] <= capacity) {
                result += items[i][0];
                capacity -= items[i][1];
            } else {
                result += (double) items[i][0] / items[i][1] * capacity;
                capacity = 0;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        System.out.println(maximumUnits(boxTypes, 4));
    }
}
