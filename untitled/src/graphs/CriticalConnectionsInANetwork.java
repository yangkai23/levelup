package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 16/12/25
 */
public class CriticalConnectionsInANetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // init arrays to store time taken to reach node and min steps.
        int[] time = new int[n];
        int[] low = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (List<Integer> list : connections) {
            int u = list.getFirst();
            int v = list.getLast();

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();

        dfs(adjList, 0, 1, visited, ans, time, low, -1);

        return ans;

    }

    public void dfs(List<List<Integer>> connections, int node, int timeTaken, boolean[] visited, List<List<Integer>> ans, int[] time, int[] low, int parentNode) {

        visited[node] = true;
        time[node] = timeTaken;
        low[node] = timeTaken;

        for (int adjNode : connections.get(node)) {
            if (adjNode == parentNode) continue;
            if (!visited[adjNode]) {
                dfs(connections, adjNode, timeTaken + 1, visited, ans, time, low, node);
                low[node] = Math.min(low[node], low[adjNode]);
                if (low[adjNode] > time[node]) {
                    ans.add(List.of(adjNode, node));
                }

            } else {
                low[node] = Math.min(low[node], low[adjNode]);
            }
        }

    }
}
