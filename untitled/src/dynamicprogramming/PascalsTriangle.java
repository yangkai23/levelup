package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 14/01/26
 */
public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0)
            return ans;

        for (int i = 0; i < numRows; i++) {
            ans.add(new ArrayList<>());
        }

        ans.getFirst().add(1);

        for (int i = 1; i < numRows; i++) {
            for (int k = 0; k <= i; k++) {
                if (k == 0 || k == i) {
                    ans.get(i).add(1);
                } else {
                    ans.get(i).add(ans.get(i - 1).get(k) + ans.get(i - 1).get(k - 1));
                }
            }
        }
        return ans;
    }
}
