package twopointers;

/**
 * @author Anirudh
 * @since 23/10/25
 */
public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(matrix, 13));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = (matrix.length * matrix[0].length) - 1;
        int colLength = matrix[0].length;
        while (low <= high) {
            int mid = (low + high) / 2;
            int val = matrix[mid / colLength][mid % colLength];
            if (target == val)
                return true;
            if (val < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}
