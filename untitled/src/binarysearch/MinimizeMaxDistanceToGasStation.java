package binarysearch;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author Anirudh
 * @since 22/10/25
 */
public class MinimizeMaxDistanceToGasStation {
    public static void main(String[] args) {
        int[] arr = {3, 6, 12, 19, 33, 44, 67, 72, 89, 95};
        System.out.println(minimiseMaxDistanceBinarySearch(arr, 2));
    }

    /**
     * Brute-force approach to minimize the maximum distance between adjacent
     * gas stations after adding k new gas stations.
     * <p>
     * Idea:
     * - Each interval between consecutive gas stations can be split into
     * multiple smaller sections by inserting new stations.
     * - At every step, place one gas station in the interval that currently
     * has the maximum section length.
     * - Repeat this process k times.
     * <p>
     * The array 'howMany' keeps track of how many additional gas stations
     * are inserted in each interval.
     * <p>
     * Time Complexity: O(k * n)
     * - For each of the k gas stations, we scan all n-1 intervals
     * <p>
     * Space Complexity: O(n)
     * - Extra array to track inserted stations per interval
     *
     * @param arr sorted array of existing gas station positions
     * @param k   number of additional gas stations to be placed
     * @return minimized maximum distance between adjacent gas stations
     */
    public static double minimiseMaxDistanceBrute(int[] arr, int k) {
        int n = arr.length;

        // howMany[i] represents how many gas stations are added
        // between arr[i] and arr[i + 1]
        int[] howMany = new int[n - 1];

        // Place each gas station one by one
        for (int gasStations = 1; gasStations <= k; gasStations++) {
            double maxSection = -1;
            int maxIndex = -1;

            // Find the interval with the maximum current section length
            for (int i = 0; i < n - 1; i++) {
                double diff = arr[i + 1] - arr[i];
                double sectionLength = diff / (double) (howMany[i] + 1);

                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxIndex = i;
                }
            }

            // Insert a gas station in the selected interval
            howMany[maxIndex]++;
        }

        // Compute the final maximum section length
        double ans = -1;
        for (int i = 0; i < n - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            double sectionLength = diff / (double) (howMany[i] + 1);
            ans = Math.max(ans, sectionLength);
        }

        return ans;
    }


    /**
     * Optimized greedy solution using a Priority Queue to minimize the maximum
     * distance between adjacent gas stations after adding k new stations.
     * <p>
     * Idea:
     * - Each interval between two gas stations is treated independently.
     * - We always split the interval that currently has the maximum section length.
     * - A max-heap (priority queue) is used to efficiently retrieve the interval
     * with the largest section at each step.
     * <p>
     * The array 'howMany' tracks how many gas stations have been added
     * in each interval.
     * <p>
     * Time Complexity: O((n + k) log n)
     * - Initial heap construction takes O(n)
     * - Each of the k insertions takes O(log n)
     * <p>
     * Space Complexity: O(n)
     * - Priority queue and auxiliary tracking array
     *
     * @param arr sorted array of existing gas station positions
     * @param k   number of additional gas stations to be added
     * @return minimized maximum distance between adjacent gas stations
     */
    public static double minimiseMaxDistancePQ(int[] arr, int k) {
        int n = arr.length;

        // howMany[i] represents how many gas stations are added
        // between arr[i] and arr[i + 1]
        int[] howMany = new int[n - 1];

        // Max-heap based on the current maximum section length
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing((Pair pair) -> pair.first).reversed().thenComparing((Pair p) -> p.second, Comparator.reverseOrder()));

        // Initialize heap with original intervals
        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair(arr[i + 1] - arr[i], i));
        }

        // Place k gas stations greedily
        for (int gasStations = 1; gasStations <= k; gasStations++) {
            Pair p = pq.poll();

            // Add a gas station in the interval with the largest section
            howMany[p.second]++;

            double diff = arr[p.second + 1] - arr[p.second];
            double sectionLength = diff / (double) (howMany[p.second] + 1);

            // Push updated interval back into the heap
            pq.add(new Pair(sectionLength, p.second));
        }

        // The maximum section length after all insertions
        return pq.peek().first;
    }


    /**
     * Minimizes the maximum distance between adjacent gas stations after adding
     * at most k new gas stations.
     * <p>
     * This method uses binary search on the answer:
     * - The minimum possible distance is 0.
     * - The maximum possible distance is the maximum gap between existing stations.
     * <p>
     * For a candidate distance (mid), we calculate how many additional gas
     * stations are required so that no adjacent distance exceeds mid.
     * If more than k stations are needed, the distance is too small.
     * <p>
     * The search continues until the difference between low and high is within
     * defined precision (epsilon).
     * <p>
     * Time Complexity: O(n log D)
     * - n is the number of existing gas stations
     * - D is the range of distances (continuous search space)
     * <p>
     * Space Complexity: O(1)
     *
     * @param arr sorted array of existing gas station positions
     * @param k   number of additional gas stations allowed
     * @return the minimized maximum distance between adjacent gas stations
     */
    public static double minimiseMaxDistanceBinarySearch(int[] arr, int k) {
        int n = arr.length;
        double low = 0;
        double high = 0;

        // Determine the maximum initial gap
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }

        double diff = 1e-6;

        // Binary search on floating-point distance
        while (high - low > diff) {
            double mid = (low + high) / 2.0;
            int count = numOfGasStationsRequired(mid, arr);

            if (count > k) low = mid;   // distance too small, need more stations
            else high = mid;  // valid distance, try minimizing further
        }
        return high;
    }

    /**
     * Calculates the number of additional gas stations required so that
     * the distance between any two adjacent stations does not exceed
     * the given maximum distance.
     * <p>
     * For each gap between stations:
     * - We compute how many stations are needed to split the gap such that
     * each segment length is at most 'dist'.
     *
     * @param dist maximum allowed distance between adjacent stations
     * @param arr  sorted array of existing gas station positions
     * @return number of additional gas stations required
     */
    private static int numOfGasStationsRequired(double dist, int[] arr) {
        int count = 0;

        for (int i = 1; i < arr.length; i++) {
            double gap = arr[i] - arr[i - 1];
            int numInBetween = (int) (gap / dist);
            count += numInBetween;
        }
        return count;
    }

}

class Pair {
    public Pair(double first, int second) {
        this.first = first;
        this.second = second;
    }

    double first;
    int second;

    @Override
    public String toString() {
        return "Pair{" + "first=" + first + ", second=" + second + '}';
    }
}
