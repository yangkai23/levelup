package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 02/02/26
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0;
        int cnt2 = 0;

        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        int n = nums.length;

        for (int num : nums) {
            if (cnt1 == 0 && el2 != num) {
                cnt1 = 1;
                el1 = num;
            } else if (cnt2 == 0 && el1 != num) {
                cnt2 = 1;
                el2 = num;
            } else if (el1 == num)
                cnt1++;
            else if (el2 == num)
                cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for (int val : nums) {
            if (val == el1)
                cnt1++;
            if (val == el2)
                cnt2++;
        }

        List<Integer> ans = new ArrayList<>();

        int threshold = (n / 3) + 1;

        if (cnt1 >= threshold) {
            ans.add(el1);

        }
        if (cnt2 >= threshold && el1 != el2) {
            ans.add(el2);

        }

        return ans;

    }
}
