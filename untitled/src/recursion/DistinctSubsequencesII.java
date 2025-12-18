package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Anirudh
 * @since 17/12/25
 */
public class DistinctSubsequencesII {
    public static void main(String[] args) {
        System.out.println(distinctSubSeqII("aaa"));
    }

    public static int distinctSubSeqII(String s) {
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i);
        }
        Set<List<Integer>> subSeq = new HashSet<>();
        generateSubSets(nums, new ArrayList<>(), subSeq, 0);
        return subSeq.size() - 1;
    }

    private static void generateSubSets(int[] nums, List<Integer> currSubset, Set<List<Integer>> result, int idx) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(currSubset));
            return;
        }

        currSubset.addLast(nums[idx]);
        generateSubSets(nums, currSubset, result, idx + 1);
        currSubset.removeLast();
        generateSubSets(nums, currSubset, result, idx + 1);

    }
}
