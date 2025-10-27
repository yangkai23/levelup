package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 27/10/25
 */
public class DepthFirstSearch {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        // Component 1
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        // Component 2
        adj.get(3).add(4);
        adj.get(4).add(3);

        int v = 5;
        List<Integer> ans = dfsOfGraph(v, adj);
        for (Integer an : ans) {
            System.out.print(an + " ");
        }
    }

    private static List<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {

        int start = 0;
        boolean[] visited = new boolean[v];
        List<Integer> dfs = new ArrayList<>();
        dfs(visited, start, adj, dfs);

        return dfs;
    }

    private static void dfs(boolean[] visited, int node, ArrayList<ArrayList<Integer>> adj, List<Integer> dfs) {
        visited[node] = true;
        dfs.add(node);
        for (Integer neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                dfs(visited, neighbour, adj, dfs);
            }
        }
    }

}
