package strings;

import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Anirudh
 * @since 02/11/25
 */
public class DeleteColumnsToMakeSorted {
    public static void main(String[] args) {
        String[] strs = {"cba", "daf", "ghi"};
        System.out.println(minDeletionSize(strs));
    }

    public static int minDeletionSize(String[] strs) {
        int n = strs.length;
        int k = strs[0].length();
        int count = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 1; j < n; j++) {
                if (strs[j - 1].charAt(i) > strs[j].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
