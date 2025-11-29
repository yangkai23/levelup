package binarysearch;

/**
 * @author Anirudh
 * @since 25/11/25
 */
public class FindKthRotation {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6,  0, 1, 2};
        System.out.println(findKRotation(arr));
    }

    public static int findKRotation(int[] arr) {
        int low = 0;
        int n = arr.length;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (low > 0 && arr[low - 1] > arr[low])
                return low;
            if (arr[low] <= arr[mid]) {
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }
        return low==n?0:low;

    }
}
