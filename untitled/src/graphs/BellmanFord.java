package graphs;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 07/12/25
 */
public class BellmanFord {
    public int[] bellmanFord(int V, int[][] edges, int src) {

        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);
        dist[src] = 0;

        while (V > 1) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (dist[u] != 1e8 && (dist[u] + wt) < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
            V--;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if (dist[u] != 1e8 && (dist[u] + wt) < dist[v]) {
                return new int[]{-1};
            }
        }
        return dist;

    }
}
