package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Anirudh
 * @since 01/12/25
 */
public class ShortestPathInDirectedAcyclicGraph {
    public int[] shortestPath(int V, int E, int[][] edges) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adjList.get(u).add(new int[]{v, wt});

        }
        Stack<Integer> stack = findTopo(adjList, V);
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[0] = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (dist[node] != (int) 1e9) {
                for (int[] adjNode : adjList.get(node)) {
                    int curr = dist[node] + adjNode[1];
                    dist[adjNode[0]] = Math.min(curr, dist[adjNode[0]]);
                }
            } else {
                dist[node] = -1;
            }

        }
        return dist;


    }

    private Stack<Integer> findTopo(List<List<int[]>> adjList, int V) {
        boolean[] visited = new boolean[adjList.size()];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(stack, adjList, visited, i);
            }
        }
        return stack;
    }

    private void dfs(Stack<Integer> stack, List<List<int[]>> adjList, boolean[] visited, int node) {
        visited[node] = true;

        for (int[] adjNode : adjList.get(node)) {
            if (!visited[adjNode[0]]) {
                dfs(stack, adjList, visited, adjNode[0]);
            }
        }
        stack.add(node);
    }
}
