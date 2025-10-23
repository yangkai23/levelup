package binarysearch;

/**
 * @author Anirudh
 * @since 22/10/25
 */
public class KthSmallestProductOfTwoSortedArrays {
    public static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        long low = Math.min(Math.min((long) nums1[0] * nums2[0], (long) nums1[0] * nums2[n2 - 1]),
                Math.min((long) nums1[n1 - 1] * nums2[0], (long) nums1[n1 - 1] * nums2[n2 - 1]));
        long high = Math.max(Math.max((long) nums1[0] * nums2[0], (long) nums1[0] * nums2[n2 - 1]),
                Math.max((long) nums1[n1 - 1] * nums2[0], (long) nums1[n1 - 1] * nums2[n2 - 1]));

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (countPairs(nums1, nums2, mid) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static long countPairs(int[] nums1, int[] nums2, long target) {
        long count = 0;
        for (int a : nums1) {
            if (a > 0) {
                int low = 0;
                int high = nums2.length;
                while (low < high) {
                    int mid = (low + high) / 2;
                    if ((long) a * nums2[mid] <= target) low = mid + 1;
                    else
                        high = mid;
                }
                count += low;
            } else if (a < 0) {
                int low = 0;
                int high = nums2.length;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if ((long) a * nums2[mid] <= target) high = mid;
                    else
                        low = mid + 1;
                }
                count += nums2.length - low;
                if (target >= 0)
                    count += nums2.length;
            }
        }
        return count;
    }
}
