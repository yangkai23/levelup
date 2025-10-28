package strings;

/**
 * @author Anirudh
 * @since 27/10/25
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }
    public static String intToRoman(int num) {
        int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            if (num == 0)
                break;
            int times = num / value[i];
            while (times > 0) {
                result.append(roman[i]);
                times--;
            }
            num = num % value[i];

        }
        return result.toString();
    }
}
