package daily;

/**
 * @author Anirudh
 * @since 13/11/25
 */
public class MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1 {
    public static void main(String[] args) {
        int[] nums={1,1};
        System.out.println(minOperations(nums));
    }
    public static int minOperations(int[] nums) {
        int count1 = 0;
        int n = nums.length;
        for (int val : nums) {
            if (val == 1)
                count1++;
        }
        if (count1 > 0) {
            return n - count1;
        }
        int minOperations = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int gcd = nums[i];
            for (int j = i + 1; j < n; j++) {
                gcd = gcd(gcd, nums[j]);
                if (gcd == 1) {
                    minOperations = Math.min(minOperations, j - i);
                    break;
                }
            }
        }
        if (minOperations == Integer.MAX_VALUE)
            return -1;
        return minOperations + (n - 1);
    }

    static int gcd(int a, int b) {
        if (b > a) {
            gcd(b, a);
        }
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
