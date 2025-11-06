package daily;


import java.util.*;

/**
 * @author Anirudh
 * @since 04/11/25
 */
public class FindXSumOfAllKLongSubarraysI {
    public static void main(String[] args) {
        int[] nums = {3, 8, 7, 8, 7, 5};
        System.out.println(Arrays.toString(findXSum(nums, 2, 2)));
    }
    public static int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int[] freq = new int[51];
        for (int i = 0; i < k; i++) {
            freq[nums[i]]++;
        }
        for (int left = 0; left + k < n; left++) {
            result[left] = computeXSum(freq, x);
            if (left + k < n) {
                freq[nums[left]]--;
                freq[nums[left + k]]++;
            }
        }
        return result;
    }


    public static int computeXSum(int[] freq,int x) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 51; i++) {
            if (freq[i] > 0) list.add(new int[]{i, freq[i]});
        }
        list.sort((a, b) -> {
            if (b[1] != a[1]) return b[1] - a[1];
            return b[0] - a[0];
        });

        int sum = 0;
        for (int i = 0; i < list.size() && i < x; i++) {
            sum += list.get(i)[0] * list.get(i)[1];
        }
        return sum;

    }


}
