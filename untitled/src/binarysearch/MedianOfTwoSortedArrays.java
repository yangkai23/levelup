package binarysearch;

/**
 * @author Anirudh
 * @since 22/10/25
 */
public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArraysWithoutBS(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;
        int n = (n1 + n2);
        int ind2 = n / 2;
        int ind1 = ind2 - 1;
        int count = 0;
        int ind1el = -1;
        int ind2el = -1;

        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                if (count == ind1)
                    ind1el = nums1[i];
                if (count == ind2)
                    ind2el = nums1[i];
                count++;
                i++;
            } else {
                if (count == ind1)
                    ind1el = nums2[j];
                if (count == ind2)
                    ind2el = nums2[j];
                count++;
                j++;
            }
        }
        while (i < n1) {

            if (count == ind1)
                ind1el = nums1[i];
            if (count == ind2)
                ind2el = nums1[i];
            count++;
            i++;

        }
        while (j < n2) {
            if (count == ind1)
                ind1el = nums2[j];
            if (count == ind2)
                ind2el = nums2[j];
            count++;
            j++;
        }
        if (n % 2 == 1)
            return ind2el;
        return (double) (ind1el + ind2el) / (2.0);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int low = 0;
        int high = n1;
        int left = (n1 + n2 + 1) / 2;
        while (low <= high) {
            int mid1 = (low + high) >> 2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if (mid1 < n1) r1 = nums1[mid1];
            if (mid2 < n2) r2 = nums2[mid2];
            if (mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = nums2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1)
                    return Math.max(l1, l2);
                return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        int[] nums1 = {2};
        int[] nums2 = {};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
