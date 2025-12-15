package graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Anirudh
 * @since 15/12/25
 */
public class MostStonesRemovedWithSameRowOrColumn {
    public static void main(String[] args) {
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(removeStones(stones));
    }

    public static int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);

        Set<Integer> uniqueParent = new HashSet<>();

        for (int[] stone : stones) {
            int nodeRow = stone[0];
            int nodeCol = stone[1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            uniqueParent.add(nodeRow);
            uniqueParent.add(nodeCol);

        }
        int count = 0;
        for (int val : uniqueParent) {
            if (ds.findUltimateParent(val) == val) {
                count++;
            }
        }

        return stones.length - count;

    }
}
