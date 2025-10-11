package greedy;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 03/10/25
 */
public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {0, 0};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strNums = new String[n];
        for (int i = 0; i < n; i++) {
            strNums[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        if (strNums[0].equals("0")) return "0";

        StringBuilder result = new StringBuilder();
        for (String s : strNums)
            result.append(s);
        return result.toString();

    }
}
