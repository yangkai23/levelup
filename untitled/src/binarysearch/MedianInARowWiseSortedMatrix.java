package binarysearch;

/**
 * @author Anirudh
 * @since 25/10/25
 */
public class MedianInARowWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 7, 9, 11}, {2, 3, 4, 5, 10}, {9, 10, 12, 14, 16}};
        System.out.println(findMedian(matrix));
    }

    public static int findMedian(int[][] matrix) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        for (int[] arr : matrix) {
            low = Math.min(arr[0], low);
            high = Math.max(high, arr[m - 1]);
        }
        int numOnEachSide = (m * n) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            int leftSideCount = getNumOnLeftSide(matrix, n, m, mid);
            if (leftSideCount <= numOnEachSide)
                low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    private static int getNumOnLeftSide(int[][] matrix, int n, int m, int val) {
        int count = 0;
        for (int[] arr : matrix) {
            int low = 0;
            int high = m - 1;
            int currCount = m;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] >val) {
                    currCount = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            count += currCount;
        }
        return count;
    }
}
