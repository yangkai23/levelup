package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 20/12/25
 */
public class PermutationSequence {
    /**
     * Returns the k-th permutation sequence of numbers from 1 to n
     * in lexicographical order.
     *
     * <p>
     * This method uses the factorial number system to compute the result
     * directly without generating all permutations.
     * </p>
     *
     * <p>
     * Approach:
     * <ul>
     *   <li>There are n! Permutations of numbers 1..n.</li>
     *   <li>Each fixed first digit contributes (n-1)! Permutations.</li>
     *   <li>Using k, we determine which block the permutation belongs to.</li>
     *   <li>We iteratively pick digits based on factorial division.</li>
     * </ul>
     * </p>
     *
     * <p>
     * Steps:
     * <ol>
     *   <li>Compute (n-1)!.</li>
     *   <li>Store numbers 1…n in a list.</li>
     *   <li>Convert k to zero-based indexing.</li>
     *   <li>Select digits using k / fact and update k and fact.</li>
     * </ol>
     * </p>
     *
     * @param n the number of digits (1 to n)
     * @param k the 1-based index of the required permutation
     * @return the k-th permutation as a string
     * @timeComplexity O(n ²) due to list removals
     * @spaceComplexity O(n) for storing remaining digits
     */
    public static String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact *= i;
            nums.add(i);
        }
        nums.add(n);
        k = k - 1;
        StringBuilder res = new StringBuilder();
        while (true) {
            res.append(nums.get(k / fact));
            nums.remove(k / fact);
            if (nums.isEmpty())
                return res.toString();
            k = k % fact;
            fact = fact / nums.size();
        }
    }

}
