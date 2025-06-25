package slidingwindow;

/**
 * @author shanmukhaanirudhtalluri
 * @date 25/06/25
 */
public class MaximumPointsYouCanObtainFromCards {
    public static int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int left = k - 1;
        int right = len - 1;
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        int sum = leftSum;
        while (left >= 0 && right >= (len - k)) {
            rightSum += cardPoints[right--];
            leftSum -= cardPoints[left--];
            sum = Math.max(sum, leftSum + rightSum);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ar = {32,69,37,79,4,33,29,33,45,1,99,90,56,24,76};
        System.out.println(maxScore(ar, 10));
    }
}
