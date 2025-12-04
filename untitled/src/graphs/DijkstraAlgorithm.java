package graphs;


import java.util.*;

/**
 * @author Anirudh
 * @since 03/12/25
 */
public class DijkstraAlgorithm {
    public int[] dijkstraUsingPQ(int V, int[][] edges, int src) {
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
        PriorityQueue<MyPair> q = new PriorityQueue<>(Comparator.comparing((MyPair p) -> p.dist));
        int[] shortDist = new int[V];
        Arrays.fill(shortDist, (int) 1e9);
        shortDist[src] = 0;
        q.add(new MyPair(0, src));
        while (!q.isEmpty()) {
            MyPair polled = q.poll();
            for (int[] adjPair : adjList.get(polled.node)) {
                int adjNode = adjPair[0];
                int adjWt = adjPair[1];
                if (shortDist[adjNode] > (polled.dist + adjWt)) {
                    shortDist[adjNode] = polled.dist + adjWt;
                    q.add(new MyPair(shortDist[adjNode], adjNode));
                }
            }
        }
        return shortDist;

    }

    public int[] dijkstraUsingSet(int V, int[][] edges, int src) {
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
        TreeSet<MyPair> set = new TreeSet<>((a, b) -> {
            if (a.dist != b.dist)
                return Integer.compare(a.dist, b.dist);
            return Integer.compare(a.node, b.node);
        });
        int[] shortDist = new int[V];
        Arrays.fill(shortDist, (int) 1e9);
        shortDist[src] = 0;
        set.add(new MyPair(0, src));
        while (!set.isEmpty()) {
            MyPair cur = set.pollFirst();
            int u = cur.node;

            for (int[] nbr : adjList.get(u)) {
                int v = nbr[0];
                int wt = nbr[1];

                if (shortDist[v] > shortDist[u] + wt) {

                    set.remove(new MyPair(shortDist[v], v));

                    shortDist[v] = shortDist[u] + wt;

                    set.add(new MyPair(shortDist[v], v));
                }
            }
        }
        return shortDist;

    }

}

class MyPair {
    int dist;
    int node;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyPair myPair = (MyPair) o;
        return dist == myPair.dist && node == myPair.node;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dist, node);
    }

    MyPair(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}