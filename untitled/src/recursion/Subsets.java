package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 05/11/25
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubSets(nums, new ArrayList<>(), result, 0);
        return result;
    }

    private static void generateSubSets(int[] nums, ArrayList<Integer> currSubset, List<List<Integer>> result, int idx) {
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
