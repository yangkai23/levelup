package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 04/11/25
 */
public class FindEventualSafeStates {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(eventualSafeNodes(graph));
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] pathTaken = new int[n];
        int[] check = new int[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(visited, pathTaken, check, graph, i);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (check[i] == 1)
                result.add(i);
        }
        return result;
    }

    private static boolean dfs(boolean[] visited, int[] pathTaken, int[] check, int[][] graph, int node) {
        // mark as visited
        visited[node] = true;
        //path taken first it'll be 1 , when coming back if we don't see cycle then we'll mark it as 0
        pathTaken[node] = 1;
        // we set this 0 initially and if we don't detect any cycle , then that path leads to terminal node
        check[node] = 0;

        for (int adjNode : graph[node]) {
            if (!visited[adjNode]) {
                if (dfs(visited, pathTaken, check, graph, adjNode))
                    return true;
            } else if (pathTaken[adjNode] == 1)
                return true;
        }
        pathTaken[node] = 0;
        check[node] = 1;
        return false;
    }
}
