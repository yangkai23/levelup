package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Anirudh
 * @since 15/12/25
 */
public class StronglyConnected {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(
                List.of(
                        new ArrayList<>(List.of(1, 0)),
                        new ArrayList<>(List.of(0, 2)),
                        new ArrayList<>(List.of(2, 1)),
                        new ArrayList<>(List.of(0, 3)),
                        new ArrayList<>(List.of(3, 4))
                )
        );
        System.out.println(kosaraju(list));

    }

    public static int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        // first sort the nodes based on dist (need to perform dfs)
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                dfs(stack, adj, i, visited);
        }

        // reverse the graph
        ArrayList<ArrayList<Integer>> revEdges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            revEdges.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            visited[i] = false;
            for (int adjNode : adj.get(i)) {
                revEdges.get(adjNode).add(i);
            }
        }
        // do dfs in stack order as it was sorted based on dist
        int strongComponents = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                strongComponents++;
                dfs(revEdges, node, visited);
            }
        }

        return strongComponents;


    }

    public static void dfs(Deque<Integer> stack, ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited) {

        visited[node] = true;
        for (int adjNode : adj.get(node)) {
            if (!visited[adjNode]) {
                dfs(stack, adj, adjNode, visited);
            }
        }

        stack.push(node);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited) {

        visited[node] = true;
        for (int adjNode : adj.get(node)) {
            if (!visited[adjNode]) {
                dfs(adj, adjNode, visited);
            }
        }

    }
}
