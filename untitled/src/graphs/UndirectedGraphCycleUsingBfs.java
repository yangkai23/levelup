package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Anirudh
 * @since 29/10/25
 */
public class UndirectedGraphCycleUsingBfs {
    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
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
            if (!visited[i]) {
                if (detect(i, adjList, visited)) return true;
            }
        }
        return false;
    }


    private static boolean detect(int V, List<List<Integer>> adjList, boolean[] visited) {
        visited[V] = true;
        Deque<Pair> deque = new ArrayDeque<>();
        deque.add(new Pair(V, -1));
        while (!deque.isEmpty()) {
            Pair p = deque.poll();
            int node = p.first;
            int parent = p.second;
            for (int adjNode : adjList.get(node)) {
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    deque.push(new Pair(adjNode, node));
                } else if (parent != adjNode) {
                    return true;
                }
            }
        }
        return false;
    }

}
