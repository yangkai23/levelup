package graphs;


/**
 * @author Anirudh
 * @since 29/10/25
 */
public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provincesCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(visited, isConnected, i);
                provincesCount++;
            }
        }
        return provincesCount;
    }

    private static void dfs(boolean[] visited, int[][] isConnected, int node) {
        visited[node] = true;
        for (int neigh = 0; neigh < isConnected[node].length; neigh++) {
            if (isConnected[node][neigh] == 1 && !visited[neigh]) {
                dfs(visited, isConnected, neigh);
            }
        }
    }
}
