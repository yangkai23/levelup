package greedy;

import java.util.List;

/**
 * @author Anirudh
 * @since 09/10/25
 */
public class MaximumDistanceInArrays {
    public static void main(String[] args) {
        List<List<Integer>> arrays = List.of(List.of(1, 2, 3), List.of(4, 5), List.of(1, 2, 3));
        System.out.println(maxDistance(arrays));
    }

    public static int maxDistance(List<List<Integer>> arrays) {
        int minSoFar = arrays.getFirst().getFirst();
        int maxSoFar = arrays.getFirst().getLast();
        int maxDist = 0;
        for (List<Integer> array : arrays) {
            int minInArr = array.getFirst(), maxInArr = array.getLast();
            maxDist = Math.max(maxDist, Math.max(maxSoFar - minInArr, maxInArr - maxSoFar));
            minSoFar = Math.min(minSoFar, minInArr);
            maxSoFar = Math.max(maxSoFar, maxInArr);
        }

        return maxDist;

    }
}
