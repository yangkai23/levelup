package recursion;

/**
 * @author Anirudh
 * @since 21/12/25
 */
public class CountInversions {
    static int inversionCount(int arr[]) {

        return splitArr(arr, 0, arr.length - 1);

    }

    static int splitArr(int[] arr, int start, int end) {

        int cnt = 0;

        if (start >= end) {
            return cnt;
        }
        int mid = (start + end) / 2;
        cnt += splitArr(arr, start, mid);
        cnt += splitArr(arr, mid + 1, end);
        cnt += merge(arr, start, mid, end);
        return cnt;

    }

    static int merge(int[] arr, int start, int mid, int end) {

        int i = start;
        int j = mid + 1;
        int cnt = 0;
        int[] temp = new int[end - start + 1];
        int idx = 0;

        while (i <= mid && j <= end) {
            if (arr[i] > arr[j]) {
                cnt += mid - i + 1;
                temp[idx] = arr[j];
                j++;
            } else {
                temp[idx] = arr[i];
                i++;
            }
            idx++;

        }

        while (i <= mid) {
            temp[idx] = arr[i];
            idx++;
            i++;
        }
        while (j <= end) {
            temp[idx] = arr[j];
            j++;
            idx++;
        }
        int k = start;

        for (int val : temp) {
            arr[k] = val;
            k++;
        }

        return cnt;

    }
}
