package binarysearch;

/**
 * @author Anirudh
 * @since 18/10/25
 */
public class KthMissingPositiveNumber {


    public static void main(String[] args) {
        int[] arr = {4};
        System.out.println(findKthPositive(arr, 5));
    }

    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        if (n == 1 && k<arr[0]) {
            return Math.abs(arr[0] - k);
        }
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int currMissing = arr[mid] - mid - 1;
            if (currMissing < k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        if (high < 0) {
            return arr[low] - (arr[low] - low - 1) + k - 1;
        }
        return arr[high] + (k - (arr[high] - high - 1));


    }
}
