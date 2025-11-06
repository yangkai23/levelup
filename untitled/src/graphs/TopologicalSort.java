package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Anirudh
 * @since 05/11/25
 */
public class TopologicalSort {
    public static void main(String[] args) {
        int[][] edges = {{3, 0}, {1, 0}, {2, 0}};
        System.out.println(topoSort(4, edges));
    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= V; i++)
            adjList.add(new ArrayList<>());
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }
        boolean[] visited = new boolean[V];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(stack, visited, adjList, i);
        }
        return new ArrayList<>(stack);


    }

    private static void dfs(Deque<Integer> stack, boolean[] visited, List<List<Integer>> adjList, int node) {
        visited[node] = true;
        for (int adjNode : adjList.get(node)) {
            if (!visited[adjNode]) {
                dfs(stack, visited, adjList, adjNode);
            }
        }
        stack.push(node);
    }
}
