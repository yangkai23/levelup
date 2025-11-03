package strings;

/**
 * @author Anirudh
 * @since 03/11/25
 */
public class MinimumTimeToMakeRopeColorful {
    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = {1, 2, 3, 4, 5};
        System.out.println(minCost(colors, neededTime));
    }

    public static int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int total = 0;
        for (int i = 1; i < n; i++) {
            int minTime = 0;
            if (colors.charAt(i - 1) == colors.charAt(i)) {
                if (neededTime[i - 1] < neededTime[i]) {
                    minTime = neededTime[i - 1];

                } else {
                    minTime = neededTime[i];
                    neededTime[i] = neededTime[i - 1];
                }
            }

            total += minTime;


        }
        return total;
    }
}
