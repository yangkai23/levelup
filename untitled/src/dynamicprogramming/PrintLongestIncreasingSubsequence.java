package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Anirudh
 * @since 03/01/26
 */
public class PrintLongestIncreasingSubsequence {
    public ArrayList<Integer> getLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int lastIndex = 0;

        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }

            }

            if (dp[i] > max) {
                max = dp[i];
                lastIndex = i;
            }

        }

        ArrayList<Integer> ls = new ArrayList<>();
        ls.add(nums[lastIndex]);

        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            ls.add(nums[lastIndex]);
        }


        Collections.reverse(ls);

        return ls;

    }
}
