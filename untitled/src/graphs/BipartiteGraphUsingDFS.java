package graphs;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 02/11/25
 */
public class BipartiteGraphUsingDFS {
    public static void main(String[] args) {
        int[][] graph = {
                {1, 2},    // Node 0 connected to 1 and 2
                {0, 3},    // Node 1 connected to 0 and 3
                {0, 3},    // Node 2 connected to 0 and 3
                {1, 2}
        };
        System.out.println(isBipartite(graph));
    }

    private static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] coloured = new int[n];
        Arrays.fill(coloured, -1);
        for (int i = 0; i < n; i++) {
            if (coloured[i] == -1) {
                if (!dfs(graph, i, coloured, 1))
                    return false;
            }
        }
        return true;
    }

    public static boolean dfs(int[][] graph, int node, int[] coloured, int color) {

        coloured[node] = (color ^ 1);

        for (int adjNode : graph[node]) {
            if (coloured[adjNode] == -1) {
                if (!dfs(graph, adjNode, coloured, coloured[node]))
                    return false;
            } else {
                if (coloured[adjNode] == coloured[node])
                    return false;
            }
        }
        return true;
    }
}
