package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 02/11/25
 */
public class DirectedCyclicGraph {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {2,0}, {1, 2}, {2, 3}};
        System.out.println(isCyclic(edges.length, edges));
    }

    public static boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= V; i++)
            adjList.add(new ArrayList<>());
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }
        boolean[] visited = new boolean[V+1];
        int[] pathTaken = new int[V+1];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(adjList, visited, i, pathTaken))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(List<List<Integer>> adjList, boolean[] visited, int node, int[] pathTaken) {
        visited[node] = true;
        pathTaken[node] = 1;
        for (int adjNode : adjList.get(node)) {
            if (!visited[adjNode]) {
                pathTaken[adjNode] = 1;
                if (dfs(adjList, visited, adjNode, pathTaken))
                    return true;
            } else {
                if (pathTaken[adjNode] == 1)
                    return true;
            }
        }
        pathTaken[node] = 0;
        return false;
    }
}
