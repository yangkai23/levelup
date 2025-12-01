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

    public static double minimiseMaxDistanceBrute(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1];
        for (int gasStations = 1; gasStations <= k; gasStations++) {
            double maxSection = -1;
            int maxIndex = -1;

            for (int i = 0; i < n - 1; i++) {
                double diff = (arr[i + 1] - arr[i]);
                double secLength = diff / (double) (howMany[i] + 1);
                if (secLength > maxSection) {
                    maxSection = secLength;
                    maxIndex = i;
                }
            }
            howMany[maxIndex]++;
        }

        double ans = -1;
        for (int i = 0; i < n - 1; i++) {
            double diff = (arr[i + 1] - arr[i]);
            double secLength = diff / (double) (howMany[i] + 1);
            ans = Math.max(ans, secLength);
        }


        return ans;
    }

    public static double minimiseMaxDistancePQ(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing((Pair pair) -> pair.first)
                .reversed()
                .thenComparing((Pair p) -> p.second, Comparator.reverseOrder()));
        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair(arr[i + 1] - arr[i], i));
        }

        for (int gasStations = 1; gasStations <= k; gasStations++) {
            Pair p = pq.poll();
            howMany[p.second]++;
            double diff = arr[p.second + 1] - arr[p.second];
            double secLength = diff / (double) (howMany[p.second] + 1);
            pq.add(new Pair(secLength, p.second));
        }

        assert pq.peek() != null;
        return pq.peek().first;
    }

    public static double minimiseMaxDistanceBinarySearch(int[] arr, int k) {
        int n = arr.length;
        double low = 0;
        double high = 0;
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }

        double diff = 1e-6;
        while (high - low > diff) {
            double mid = (low + high) / (2.0);
            int count = numOfGasStationsRequired(mid, arr);
            if (count > k)
                low = mid;
            else
                high = mid;
        }
        return high;
    }

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
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
