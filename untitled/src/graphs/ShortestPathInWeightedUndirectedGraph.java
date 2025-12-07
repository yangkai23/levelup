package graphs;

import java.util.*;

/**
 * @author Anirudh
 * @since 04/12/25
 */
public class ShortestPathInWeightedUndirectedGraph {
    public static void main(String[] args) {
        int[][] edges = {
                {1, 2, 2},
                {2, 5, 5},
                {2, 3, 4},
                {1, 4, 1},
                {4, 3, 3},
                {3, 5, 1}
        };

        System.out.println(shortestPath(5, 6, edges));
    }

    public static List<Integer> shortestPath(int n, int m, int[][] edges) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adjList.get(u).add(new int[]{v, wt});
            adjList.get(v).add(new int[]{u, wt});
        }
        int[][] dist = new int[n + 1][2];
        dist[1][0] = 0;
        dist[1][1] = 0;
        for (int i = 2; i <= n; i++) {
            dist[i][0] = (int) 1e9;
            dist[i][1] = -1;
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparing((int[] ar) -> ar[0]));

        heap.add(new int[]{0, 1});

        while (!heap.isEmpty()) {

            int[] polled = heap.poll();
            int currDist = polled[0];
            int node = polled[1];

            for (int[] adjPair : adjList.get(node)) {
                int adjNode = adjPair[0];
                int wt = adjPair[1];
                if (dist[adjNode][0] > (currDist + wt)) {
                    dist[adjNode][0] = currDist + wt;
                    dist[adjNode][1] = node;
                    heap.add(new int[]{currDist + wt, adjNode});
                }

            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(n);

        int node = n;
        while (node != 1) {
            node = dist[node][1];
            if (node == -1)
                break;
            ans.add(node);
        }
        if (node == -1) {
            ans.clear();
            ans.add(-1);
            return ans;
        }

        Collections.reverse(ans);
        ans.addFirst(dist[n][0]);
        return ans;


    }

}
