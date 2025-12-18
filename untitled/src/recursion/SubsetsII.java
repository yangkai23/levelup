package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anirudh
 * @since 18/12/25
 */
public class SubsetsII {
    public static List<List<Integer>> subsetsWithDup(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        getSubSets(arr, ans, new ArrayList<>(), 0);
        return ans;
    }

    private static void getSubSets(int[] arr, List<List<Integer>> ans, ArrayList<Integer> ds, int idx) {
        ans.add(new ArrayList<>(ds));
        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;
            ds.add(arr[i]);
            getSubSets(arr, ans, ds, i + 1);
            ds.remove(ds.size() - 1);
        }
    }
}
