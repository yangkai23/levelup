package twopointers;

import java.util.*;

/**
 * @author Anirudh
 * @since 23/10/25
 */
public class _3Sum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSumOptimal(nums));
    }

    public static List<List<Integer>> threeSumBetter(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);
                if (set.contains(third)) {
                    List<Integer> temp = new ArrayList<>(List.of(nums[i], nums[j], third));
                    temp.sort(null);
                    list.add(temp);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(list);
    }

    public static List<List<Integer>> threeSumOptimal(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0)
                    k--;
                else if (sum < 0) {
                    j++;
                } else {
                    List<Integer> temp = List.of(nums[i], nums[j], nums[k]);
                    list.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }

                }
            }
        }
        return list;
    }
}
