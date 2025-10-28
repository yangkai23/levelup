package strings;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Anirudh
 * @since 27/10/25
 */
public class StringCompression {
    public static void main(String[] args) {
        String[] chars = {"a","b","b","b","b","b","b","b","b","b","b","b","b"};
        char[] charArray = String.join("", chars).toCharArray();
        System.out.println(compress(charArray));
    }

    public static int compress(char[] chars) {
        int n = chars.length;
        int index = 0;
        int i = 0;
        while (i < n) {
            char currentChar = chars[i];
            int count = 0;
            while (i < n && chars[i] == currentChar) {
                count++;
                i++;
            }

            chars[index] = currentChar;
            index++;

            if (count > 1) {
                String countStr = count + "";
                for (char c : countStr.toCharArray()) {
                    chars[index] = c;
                    index++;
                }
            }

        }
        return index;
    }
}
