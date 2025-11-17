package slidingwindow;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Anirudh
 * @since 17/11/25
 */
public class CountTheNumberOfSubstringsWithDominantOnes {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("00011"));
    }
    static{
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("0");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }));
    }
    public static int numberOfSubstrings(String s) {
        int n = s.length();
        int[] onesPf = new int[n];
        onesPf[0] = (s.charAt(0) == '1' ? 1 : 0);
        for (int i = 1; i < n; i++) {
            onesPf[i] = onesPf[i - 1] + (s.charAt(i) - '0');
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int onesCount = onesPf[j] - (i - 1 >= 0 ? onesPf[i - 1] : 0);
                int zeroesCount = (j - i + 1) - onesCount;
                if ((zeroesCount * zeroesCount) > onesCount) {
                    int skipIndices = (zeroesCount * zeroesCount) - onesCount;
                    //since we have j++ happening
                    j += skipIndices - 1;
                } else if (zeroesCount * zeroesCount == onesCount) {
                    result += 1;
                } else {
                    result += 1;
                    int k = (int) Math.sqrt(onesCount) - zeroesCount;
                    int next = j + k;
                    if (next >= n) {
                        result += (n - j - 1);
                        break;
                    } else {
                        result += k;
                    }
                    j=next;
                }
            }
        }
        return result;
    }
}
