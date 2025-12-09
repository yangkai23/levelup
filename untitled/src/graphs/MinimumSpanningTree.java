package graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Anirudh
 * @since 08/12/25
 */
public class MinimumSpanningTree {

    // Prim's Algorithm - Minimum Spanning Tree
    public int spanningTree(int V, int[][] edges) {

        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adjList.get(u).add(new int[]{v, wt});
            adjList.get(v).add(new int[]{u, wt});
        }
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparing((int[] ar) -> ar[0]));

        int sum = 0;
        // wt,node,parent.  here parent is not needed as we are not creating spanning tree
        heap.offer(new int[]{0, 0});
        while (!heap.isEmpty()) {
            int[] polled = heap.poll();
            int wt = polled[0];
            int node = polled[1];

            if (visited[node]) {
                continue;
            }
            sum += wt;
            visited[node] = true;
            for (int[] adjArr : adjList.get(node)) {
                int adjNode = adjArr[0];
                int adjNodeWt = adjArr[1];

                if (!visited[adjNode]) {
                    heap.offer(new int[]{adjNodeWt, adjNode});
                }
            }
        }
        return sum;


    }
}
