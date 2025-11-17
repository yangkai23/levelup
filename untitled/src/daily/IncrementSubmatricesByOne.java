package daily;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 15/11/25
 */
public class IncrementSubmatricesByOne {
    public static void main(String[] args) {
        int[][] queries = {{1, 1, 2, 2}, {0, 0, 1, 1}};
        System.out.println(Arrays.deepToString(rangeAddQueries(3, queries)));
    }

    public static int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] result = new int[n][n];
        for (int[] query : queries) {
            int rowStart = query[0];
            int colStart = query[1];
            int rowEnd = query[2];
            int colEnd = query[3];

            for (int i = rowStart; i <= rowEnd; i++) {
                result[i][colStart] += 1;
                if (colEnd + 1 < n)
                    result[i][colEnd + 1] -= 1;
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] += result[i][j - 1];
            }
        }
        return result;
    }
}
