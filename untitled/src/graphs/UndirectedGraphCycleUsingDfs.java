package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 29/10/25
 */
public class UndirectedGraphCycleUsingDfs {
    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println(isCycle(4, grid));

    }

    public static boolean isCycle(int V, int[][] edges) {

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] ar : edges) {
            adjList.get(ar[0]).add(ar[1]);
            adjList.get(ar[1]).add(ar[0]);
        }
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                if (dfs(adjList, visited, new Pair(i, -1)))
                    return true;
        }
        return false;
    }

    private static boolean dfs(List<List<Integer>> adjList, boolean[] visited, Pair node) {
        visited[node.first] = true;
        for (int adjNode : adjList.get(node.first)) {
            if (!visited[adjNode]) {
                if (dfs(adjList, visited, new Pair(adjNode, node.first)))
                    return true;
            } else if (node.second != adjNode) {
                return true;
            }
        }
        return false;
    }
}
