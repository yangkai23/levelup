package graphs;

/**
 * @author Anirudh
 * @since 31/01/26
 */
public class MinimumCostToConvertStringI {
    public static void main(String[] args) {
        char[] original = {'a', 'b', 'c', 'c', 'e', 'd'};
        char[] changed = {'b', 'c', 'b', 'e', 'b', 'e'};
        int[] cost = {2, 5, 5, 1, 2, 20};
        System.out.println(minimumCost("abcd", "acbe", original, changed, cost));
    }

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] dist = new int[26][26];
        int INF = (int) 1e9;
        int n = source.length();
        int m = original.length;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else
                    dist[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            dist[original[i] - 'a'][changed[i] - 'a'] = cost[i];
        }

        for (int via = 0; via < 26; via++) {
            for (int i = 0; i < dist.length; i++) {
                for (int j = 0; j < dist.length; j++) {

                    if (dist[i][via] == INF || dist[via][j] == INF)
                        continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }
        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans += dist[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
        }
        return ans;

    }
}
