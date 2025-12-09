package graphs;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 08/12/25
 */
public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        System.out.println(findTheCity(4, edges, 4));
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] dist = new int[n][n];
        int INF = (int) 1e9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = INF;
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        for (int i = 0; i < n; i++) dist[i][i] = 0;
        for (int vertex = 0; vertex < n; vertex++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][vertex] == INF || dist[vertex][j] == INF)
                        continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][vertex] + dist[vertex][j]);
                }
            }
        }
        int result = 0;
        int currMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cities = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] != INF && dist[i][j] <= distanceThreshold)
                    cities++;
            }
            if (cities <= currMin) {
                currMin = cities;
                result = i;
            }
        }

        return result;
    }
}
