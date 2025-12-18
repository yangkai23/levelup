package recursion;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Anirudh
 * @since 18/12/25
 */
public class SubsetSums {
    public ArrayList<Integer> subsetSums(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();

        findSubsetSum(arr, ans, 0, 0);
        Collections.sort(ans);
        return ans;

    }

    private void findSubsetSum(int[] arr, ArrayList<Integer> ans, int idx, int sum) {
        if (idx == arr.length) {
            ans.add(sum);
            return;
        }
        // include arr[idx]
        sum += arr[idx];
        findSubsetSum(arr, ans, idx + 1, sum);
        // exclude arr[idx]
        sum -= arr[idx];
        findSubsetSum(arr, ans, idx + 1, sum);
    }
}
