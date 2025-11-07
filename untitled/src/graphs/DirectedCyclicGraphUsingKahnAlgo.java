package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Anirudh
 * @since 07/11/25
 */
public class DirectedCyclicGraphUsingKahnAlgo {
    public static boolean isCyclic(int V, int[][] edges) {
        int[] inDegree = new int[V];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }
        for (int i = 0; i < V; i++) {
            for (int adj : adjList.get(i)) {
                inDegree[adj]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int polled = q.poll();

            result.add(polled);
            for (int adj : adjList.get(polled)) {
                inDegree[adj]--;
                if (inDegree[adj] == 0)
                    q.offer(adj);
            }
        }
        return result.size()!=V;

    }
}
