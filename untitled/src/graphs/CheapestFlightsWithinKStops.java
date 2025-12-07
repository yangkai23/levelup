package graphs;

import java.util.*;

/**
 * @author Anirudh
 * @since 06/12/25
 */
public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println(findCheapestPrice(3, flights, 0, 2, 1));

    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];
            adjList.get(u).add(new int[]{v, price});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);

        Queue<int[]> q = new LinkedList<>();
        // stops,node,price
        q.offer(new int[]{0, src, 0});
        dist[src] = 0;
        while (!q.isEmpty()) {
            int[] polled = q.poll();
            int stops = polled[0];
            int node = polled[1];
            int currPrice = polled[2];
            if (stops > k)
                continue;
            for (int[] adjArr : adjList.get(node)) {
                int adjNode = adjArr[0];
                int adjPrice = adjArr[1];

                if (dist[adjNode] > currPrice + adjPrice) {
                    dist[adjNode] = currPrice + adjPrice;
                    q.offer(new int[]{stops + 1, adjNode, currPrice + adjPrice});
                }
            }
        }
        return dist[dst] == (int) 1e9 ? -1 : dist[dst];

    }
}
