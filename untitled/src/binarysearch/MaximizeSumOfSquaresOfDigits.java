package binarysearch;

/**
 * @author Anirudh
 * @since 25/10/25
 */
public class MaximizeSumOfSquaresOfDigits {
    public static void main(String[] args) {
        System.out.println(maxSumOfSquares(2, 17));
    }

    public static String maxSumOfSquares(int num, int sum) {
        if(sum > 9 * num) return -1+"";

        int[] digits = new int[num];
        for(int i = 0; i < num; i++) {
            digits[i] = Math.min(9, sum);
            sum -= digits[i];
        }

        int ans = 0;
        for(int d : digits) {
           ans=ans*10+d;
        }
        return ans+"";
    }
}
