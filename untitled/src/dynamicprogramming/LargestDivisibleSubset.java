package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anirudh
 * @since 04/01/26
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] hash = new int[n];
        int[] dp = new int[n];
        int lastIndex = 0;
        int max = 1;

        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if ((nums[i] % nums[j] == 0) && (dp[j] + 1) > dp[i]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if (dp[i] >= max) {
                max = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> ls = new ArrayList<>();
        ls.add(nums[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            ls.add(nums[lastIndex]);
        }

        return ls;

    }
}
