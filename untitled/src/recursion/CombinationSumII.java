package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anirudh
 * @since 18/12/25
 */
public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(candidates, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }

    private static void findCombinations(int[] candidates, int target, List<List<Integer>> ans
            , List<Integer> subSeq, int idx) {
        if (target == 0) {
            ans.add(new ArrayList<>(subSeq));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target)
                break;
            subSeq.add(candidates[i]);
            findCombinations(candidates, target - candidates[i], ans, subSeq, i + 1);
            subSeq.remove(subSeq.size() - 1);
        }

    }
}
