package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 17/12/25
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(candidates, target, ans, 0, new ArrayList<>());
        return ans;
    }

    private void findCombinations(int[] candidates, int target, List<List<Integer>> ans, int idx, List<Integer> currList) {
        if (idx == candidates.length) {
            if (target == 0)
                ans.add(new ArrayList<>(currList));
            return;
        }
        if (candidates[idx] <= target) {
            currList.addLast(candidates[idx]);
            findCombinations(candidates, target - candidates[idx], ans, idx, currList);
            currList.removeLast();
        }
        findCombinations(candidates, target, ans, idx + 1, currList);

    }
}
