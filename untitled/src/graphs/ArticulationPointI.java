package graphs;

import java.util.ArrayList;

/**
 * @author Anirudh
 * @since 16/12/25
 */
public class ArticulationPointI {
    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] time = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] marked = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj, visited, marked, i, -1, low, time, 1);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (marked[i]) ans.add(i);
        }
        if (ans.isEmpty()) {
            ans.add(-1);
            return ans;
        }


        return ans;

    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] marked, int node, int parent, int[] low, int[] time, int timeTaken) {

        low[node] = timeTaken;
        time[node] = timeTaken;
        visited[node] = true;
        int child = 0;
        for (int adjNode : adj.get(node)) {
            if (adjNode == parent) continue;
            if (!visited[adjNode]) {
                dfs(adj, visited, marked, adjNode, node, low, time, timeTaken + 1);
                low[node] = Math.min(low[node], low[adjNode]);
                if (low[adjNode] >= time[node] && parent != -1) {
                    marked[node] = true;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], time[adjNode]);
            }
        }

        if (child > 1 && parent == -1) {
            marked[node] = true;
        }
    }
}
