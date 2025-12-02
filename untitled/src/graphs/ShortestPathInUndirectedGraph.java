package graphs;

import java.util.*;

/**
 * @author Anirudh
 * @since 02/12/25
 */
public class ShortestPathInUndirectedGraph {
    public int[] shortestPath(int V, int[][] edges, int src) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        int[] dist = new int[V];

        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int adjNode : adjList.get(node)) {
                if (dist[adjNode] > (dist[node] + 1)) {
                    dist[adjNode] = 1 + dist[node];
                    q.offer(adjNode);
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }
        return dist;

    }
}
