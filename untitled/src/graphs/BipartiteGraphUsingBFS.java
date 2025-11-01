package graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Anirudh
 * @since 01/11/25
 */
public class BipartiteGraphUsingBFS {
    public static void main(String[] args) {
        int[][] graph = {{2}, {1, 3, 6}, {2, 4}, {3, 5, 7}, {4, 6}, {2, 5}, {4, 8}, {7}};
        System.out.println(isBipartite(graph));
    }

    private static boolean check(int[][] graph, int[] coloured, int start) {


        Deque<Integer> deque = new ArrayDeque<>();

        deque.push(start);
        coloured[start] = 0;
        while (!deque.isEmpty()) {

            int pop = deque.pop();
            int color = coloured[pop];
            for (int node : graph[pop]) {
                if (coloured[node] == -1) {
                    coloured[node] = (color ^ 1);
                    deque.add(node);
                } else {
                    if (coloured[node] == coloured[pop])
                        return false;
                }

            }
        }
        return true;
    }

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] coloured = new int[n];
        Arrays.fill(coloured, -1);
        for (int i = 0; i < n; i++) {
            if (coloured[i] == -1)
                if (!check(graph, coloured, i))
                    return false;
        }
        return true;
    }
}
