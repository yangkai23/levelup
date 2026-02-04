package graphs;

import java.util.*;

/**
 * @author Anirudh
 * @since 27/01/26
 */
public class MinimumCostPathWithEdgeReversals {
    public static int minCost(int n, int[][] edges) {

        List<List<int[]>> adjList = new ArrayList<>();
        List<List<int[]>> revAdjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            revAdjList.add(new ArrayList<>());
        }


        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adjList.get(u).add(new int[]{v, wt});
            revAdjList.get(v).add(new int[]{u, wt});
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);

        dist[0] = 0;
        // cost, node
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int node = cur[1];

            if (node == n - 1) return cost;

            if (cost > dist[node]) continue;


            for (int[] e : adjList.get(node)) {
                int next = e[0];
                int wt = e[1];

                if (cost + wt < dist[next]) {
                    dist[next] = cost + wt;
                    pq.add(new int[]{dist[next], next});
                }
            }


            for (int[] e : revAdjList.get(node)) {
                int prev = e[0];
                int wt = e[1];

                int newCost = cost + 2 * wt;
                if (newCost < dist[prev]) {
                    dist[prev] = newCost;
                    pq.add(new int[]{newCost, prev});
                }
            }
        }

        return dist[n - 1] == (int) 1e9 ? -1 : dist[n - 1];
    }

    public static int minCost1(int n, int[][] edges) {

        List<List<int[]>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());

        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adjList.get(u).add(new int[]{v, wt});
            adjList.get(v).add(new int[]{u, 2 * wt});

        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);

        dist[0] = 0;
        // cost, node
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int node = cur[1];

            if (node == n - 1)
                return cost;

            for (int[] e : adjList.get(node)) {
                int next = e[0];
                int wt = e[1];

                if (cost + wt < dist[next]) {
                    dist[next] = cost + wt;
                    pq.add(new int[]{dist[next], next});
                }
            }


        }

        return -1;
    }
}
