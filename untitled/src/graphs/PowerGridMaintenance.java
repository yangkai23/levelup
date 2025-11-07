package graphs;

import java.util.*;

/**
 * @author Anirudh
 * @since 06/11/25
 */
public class PowerGridMaintenance {
    public static void main(String[] args) {
        int[][] connections = {{3, 2}, {1, 3}, {2, 1}};
        ;
        int[][] queries = {{2, 2}, {1, 2}, {1, 2}, {1, 3}, {1, 1}, {1, 3}, {1, 1}, {1, 1}, {2, 1}, {1, 1}, {2, 3}, {2, 3}, {2, 3}, {2, 1}, {2, 1}, {2, 1}, {1, 1}, {1, 1}, {1, 2}, {1, 2}, {2, 1}, {2, 1}, {2, 2}, {1, 2}, {1, 1}};
        System.out.println(Arrays.toString(processQueries(3, connections, queries)));
    }

    public static int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= c + 1; i++)
            adjList.add(new ArrayList<>());
        for (int[] edge : connections) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);

        }
        boolean[] status = new boolean[c + 1];
        Arrays.fill(status, true);
        /*int arrSize = 0;
        for (int[] query : queries) {
            if (query[0] == 1)
                arrSize++;
        }*/
        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 2) {
                status[query[1]] = false;
                continue;
            }
            if (!status[query[1]]) {
                int nextStation = dfsFindMinOnline(query[1],status, adjList,  new boolean[c + 1]);
                result.add(nextStation);
            } else {
                result.add(query[1]);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();

    }

    private static int dfsFindMinOnline(int node, boolean[] status, List<List<Integer>> adjList, boolean[] visited) {

        visited[node] = true;

        int best = status[node] ? node : Integer.MAX_VALUE;

        for (int next : adjList.get(node)) {
            if (!visited[next]) {
                int val = dfsFindMinOnline(next, status, adjList, visited);
                if (val != -1) best = Math.min(best, val);
            }
        }

        return best == Integer.MAX_VALUE ? -1 : best;
    }
}
