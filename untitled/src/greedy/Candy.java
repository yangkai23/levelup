package greedy;

/**
 * @author Anirudh
 * @since 30/09/25
 */
public class Candy {
    public static int candy(int[] ratings) {
        int sum = 1;
        int i = 1;
        int n = ratings.length;
        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                sum = sum + 1;
                i++;
                continue;
            }
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak += 1;
                sum += peak;

                i++;
            }
            int down = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                sum += down;
                i++;
                down++;
            }
            if (down > peak) {
                sum += down - peak;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = {1,2,2};
        System.out.println(candy(ratings));
    }
}
