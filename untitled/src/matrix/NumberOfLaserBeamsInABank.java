package matrix;

/**
 * @author Anirudh
 * @since 27/10/25
 */
public class NumberOfLaserBeamsInABank {
    public static void main(String[] args) {
        String[] bank = {"011001", "000100", "010100", "001000"};
        System.out.println(numberOfBeams(bank));
    }

    public static int numberOfBeams(String[] bank) {
        int laserCount = 0;
        int prevRowSum = 0;
        for (String s : bank) {
            int rowSum = 0;
            for (char c : s.toCharArray()) {
                rowSum += c - '0';
            }

            laserCount += rowSum * prevRowSum;
            if (rowSum != 0) {
                prevRowSum = rowSum;
            }
        }
        return laserCount;
    }
}
