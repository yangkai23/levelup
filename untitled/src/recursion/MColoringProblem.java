package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 20/12/25
 */
public class MColoringProblem {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 3}, {2, 3}, {3, 0}, {0, 2}};

        System.out.println(graphColoring(4, edges, 3));
    }


    static boolean graphColoring(int V, int[][] edges, int m) {

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

        int[] coloured = new int[V];


        return fillColour(V, adjList, m, 0, coloured);

    }

    private static boolean isSafe(List<List<Integer>> adjList, int color, int node, int[] coloured) {
        for (int adjNode : adjList.get(node)) {
            if (coloured[adjNode] == color)
                return false;
        }
        return true;
    }

    private static boolean fillColour(int v, List<List<Integer>> adjList, int m, int node, int[] coloured) {

        if (node == v) {
            return true;
        }

        for (int i = 1; i <= m; i++) {
            if (isSafe(adjList, i, node, coloured)) {
                coloured[node] = i;
                if (fillColour(v, adjList, m, node + 1, coloured)) return true;
                coloured[node] = 0;

            }
        }
        return false;
    }
}
