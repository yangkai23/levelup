package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 18/12/25
 */
public class PermutationsSwapApproach {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findPermutations(nums, ans, 0);
        return ans;

    }

    private static void findPermutations(int[] nums, List<List<Integer>> ans, int idx) {

        if (idx == nums.length)
            addToList(ans, nums);

        for (int i = idx; i < nums.length; i++) {

            swap(nums, i, idx);
            findPermutations(nums, ans, idx + 1);
            swap(nums, i, idx);
        }


    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void addToList(List<List<Integer>> ans, int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int val : nums) {
            list.add(val);
        }
        ans.add(list);
    }
}
