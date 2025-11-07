package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Anirudh
 * @since 06/11/25
 */
public class kahnAlgorithm {
    public static void main(String[] args) {
        int[][] edges = {{3, 0}, {1, 0}, {2, 0}};
        System.out.println(topoSort(4, edges));
    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
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
        for (int i=0;i<V;i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);
            for (int adj : adjList.get(node)) {
                inDegree[adj]--;
                if (inDegree[adj] == 0)
                    q.offer(adj);
            }
        }
        return result;
    }

}
