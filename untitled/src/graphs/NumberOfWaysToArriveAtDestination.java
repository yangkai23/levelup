package graphs;

import java.util.*;

/**
 * @author Anirudh
 * @since 06/12/25
 */
public class NumberOfWaysToArriveAtDestination {

    public static void main(String[] args) {
        int[][] roads = {{1, 0, 10}};

        System.out.println(countPaths(2, roads));
    }

    public static int countPaths(int n, int[][] roads) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : roads) {
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];

            adjList.get(u).add(new int[]{v, time});
            adjList.get(v).add(new int[]{u, time});
        }

        long[] dist = new long[n];
        long[] ways = new long[n];
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < n; i++) {
            dist[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }
        PriorityQueue<long[]> heap = new PriorityQueue<>(Comparator.comparing((long[] ar) -> ar[0]));
        // time,node
        heap.offer(new long[]{0, 0});

        dist[0] = 0;
        ways[0] = 1;
        while (!heap.isEmpty()) {
            long[] polled = heap.poll();
            long time = polled[0];
            int node = (int) polled[1];
            for (int[] adjArr : adjList.get(node)) {
                int adjNode = adjArr[0];
                int adjNodeTime = adjArr[1];

                long newTime = adjNodeTime + time;
                if (dist[adjNode] > newTime) {
                    dist[adjNode] = newTime;
                    ways[adjNode] = ways[node];
                    heap.offer(new long[]{newTime, adjNode});
                } else if (newTime == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return (int) (ways[n - 1] % mod);
    }
}
