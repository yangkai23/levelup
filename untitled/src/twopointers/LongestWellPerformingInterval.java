package twopointers;

import java.util.HashMap;
import java.util.Map;

public class LongestWellPerformingInterval {

    public static int longestWPI(int[] hours) {
        int[] transformed = new int[hours.length];
        for (int i = 0; i < hours.length; i++) {
            transformed[i] = hours[i] > 8 ? 1 : -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int wpi = 0;
        int sum = 0;
        for (int i = 0; i < hours.length; i++) {
            sum = sum + transformed[i];

            if (sum > 0)
                wpi = i + 1;
            else if (map.containsKey(sum - 1)) {
                wpi = Math.max(wpi, i - map.get(sum - 1));
            }

            map.putIfAbsent(sum, i);
        }
        return wpi;
    }

    public static void main(String[] args) {
        int[] hours = {9, 9, 6, 0, 6, 6, 9};
        System.out.println(longestWPI(hours));
    }
}
