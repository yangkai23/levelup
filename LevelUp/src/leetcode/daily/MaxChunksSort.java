package leetcode.daily;

public class MaxChunksSort {
    public static void main(String[] args) {
        int arr[]={1,0,3,4,2};
        System.out.println( maxChunksToSorted(arr));
    }
    public static int maxChunksToSorted(int[] arr) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if (max < i + 1) {
                count++;
            }
        }
        return count;
    }
}
