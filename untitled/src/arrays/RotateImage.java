package arrays;

/**
 * @author Anirudh
 * @since 28/01/26
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }

    }

    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        int i = 0;
        StringBuilder res=new StringBuilder();
        int j = n - 1;

        while (i < n) {
            for (int k = 0; k < j; k++) {
                int t = matrix[i][j - k - 1];
                matrix[i][j - k - 1] = matrix[i + k + 1][j];
                matrix[i + k + 1][j] = t;
            }
            i++;
            j--;

        }

        i = 0;
        j = n - 1;

        while (i < j) {
            for (int k = 0; k < n; k++) {
                int t = matrix[i][k];
                matrix[i][k] = matrix[j][k];
                matrix[j][k] = t;
            }
            i++;
            j--;
        }

    }
}
