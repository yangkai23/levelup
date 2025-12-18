package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Anirudh
 * @since 18/12/25
 */
public class PermutationsNormalApproach {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findPermutations(nums, ans, new ArrayList<Integer>(), new HashSet<Integer>());
        return ans;

    }

    private static void findPermutations(int[] nums, List<List<Integer>> ans, ArrayList<Integer> ds,
                                         HashSet<Integer> set) {

        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int num : nums) {
            if (!set.contains(num)) {
                ds.add(num);
                set.add(num);
                findPermutations(nums, ans, ds, set);
                ds.remove(ds.size() - 1);
                set.remove(num);
            }
        }


    }
}
