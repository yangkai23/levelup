package daily;

/**
 * @author Anirudh
 * @since 12/01/26
 */
public class MinimumTimeVisitingAllPoints {
    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(minTimeToVisitAllPoints(points));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {

//Chebyshev distance is the maximum absolute difference along any coordinate dimension between two points.
        // p(x1 ,y1) and 𝑞(𝑥2, 𝑦2): formula is max(|x1-x2|,|y1-y2|)
        int n = points.length;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans += Math.max(Math.abs(points[i][0] - points[i - 1][0]), Math.abs(points[i][1] - points[i - 1][1]));
        }

        return ans;

    }
}
