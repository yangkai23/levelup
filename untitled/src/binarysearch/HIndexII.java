package binarysearch;

/**
 * @author Anirudh
 * @since 26/10/25
 */
public class HIndexII {
    public static void main(String[] args) {
        int[] citations = {0,2,4,6,8,10,12,14};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        int low = 0;
        int n = citations.length;
        int high = n - 1;
        int result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            int citationCount = n - mid;
            if (citations[mid] == citationCount)
                return citations[mid];
            else if (citations[mid] > citationCount) {
                result = citationCount;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return result;
    }
}
