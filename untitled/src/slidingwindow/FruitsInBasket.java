package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shanmukhaanirudhtalluri
 * @date 02/07/25
 */
public class FruitsInBasket {
    public static void main(String[] args) {
        int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {
        int left = 0;
        if (fruits == null || fruits.length == 0) return 0;
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {

            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            if (map.size() <= 2) {
                max = Math.max(max, right - left + 1);
            }
            if (map.size() > 2) {
                if (map.get(fruits[left]) == 1)
                    map.remove(fruits[left]);
                else
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                left++;
            }
        }
        return max;
    }
}
