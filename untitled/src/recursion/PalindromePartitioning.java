package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 20/12/25
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(partition("aabb"));
    }

    public static List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        char[] arr = s.toCharArray();
        findPartitions(arr, ans, 0, new ArrayList<>());
        return ans;
    }

    private static void findPartitions(char[] arr, List<List<String>> ans, int partition, List<String> ds) {
        if (arr.length == partition) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = partition; i < arr.length; i++) {
            if (isPalindrome(arr, partition, i)) {
                StringBuilder sb = new StringBuilder();
                for (int j = partition; j <= i; j++) {
                    sb.append(arr[j]);
                }
                ds.add(sb.toString());
                findPartitions(arr, ans, i + 1, ds);
                ds.removeLast();
            }
        }
    }

    private static boolean isPalindrome(char[] arr, int start, int end) {
        while (start <= end) {
            if (arr[start] != arr[end])
                return false;
            start++;
            end--;
        }
        return true;
    }
}
