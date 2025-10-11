package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Anirudh
 * @since 11/10/25
 */
public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, Comparator.comparing(ar -> ar[1]));
        int count = 1;
        int lastGreatest = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > lastGreatest) {
                count++;
                lastGreatest = pairs[i][1];
            }

        }
        return count;
    }
}
