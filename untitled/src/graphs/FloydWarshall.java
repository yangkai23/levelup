package graphs;

/**
 * @author Anirudh
 * @since 08/12/25
 */
public class FloydWarshall {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (dist[i][via] == 100000000 || dist[via][j] == 100000000)
                        continue;

                    dist[i][j] = Math.min(dist[i][j],
                            dist[i][via] + dist[via][j]);
                }
            }
        }
    }



}
