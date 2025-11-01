package daily;

import java.util.Arrays;

/**
 * @author Anirudh
 * @since 31/10/25
 */
public class TheTwoSneakyNumbersOfDigitville {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 0};
        System.out.println(Arrays.toString(getSneakyNumbers(nums)));
        ;
    }

    public static int[] getSneakyNumbers(int[] nums) {
        int[] list = new int[nums.length];
        for (int val : nums) {
            list[val]++;
        }

        int[] result = new int[2];
        int i = 0;
        for (int j=0;j<list.length;j++) {
            if (list[j] == 2)
                result[i++] = j;
        }
        return result;
    }
}
