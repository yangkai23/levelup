package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Anirudh
 * @since 06/12/25
 */
public class MinimumMultiplicationsToReachEnd {
    public static void main(String[] args) {
        int[] arr = {20, 14, 1, 4, 20};
        System.out.println(minimumMultiplications(arr, 8, 4288));
    }

    static int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end)
            return 0;
        int[] dist = new int[100000];
        Arrays.fill(dist, (int) 1e9);
        dist[start] = 0;
        Queue<int[]> q = new LinkedList<>();
        int mod = 100000;
        // node,steps
        q.offer(new int[]{start, 0});
        while (!q.isEmpty()) {
            int[] polled = q.poll();
            int num = polled[0];
            int steps = polled[1];

            for (int j : arr) {
                int newNum = (num * j) % mod;
                if (dist[newNum] > steps + 1) {
                    dist[newNum] = steps + 1;
                    if (newNum == end)
                        return steps + 1;
                    q.offer(new int[]{newNum, steps + 1});
                }
            }
        }
        return -1;

    }
}
