package strings;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 28/10/25
 */
public class OrderlyQueue {
    public static void main(String[] args) {
        System.out.println(orderlyQueue("xisxr",1));
    }

    public static String orderlyQueue(String s, int k) {

        if (k > 1) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }

        String result = s;
        int n = s.length();
        for (int i = 1; i <= n - 1; i++) {
            String temp = s.substring(i) + s.substring(0, i);
            result = result.compareTo(temp) > 0 ? temp : result;
        }
        return result;
    }
}
