package daily;

/**
 * @author Anirudh
 * @since 14/11/25
 */
public class MaximumNumberOfOperationsToMoveOnesToTheEnd {
    public static void main(String[] args) {
        System.out.println(maxOperations("10"));
    }

    public static int maxOperations(String s) {
        int ones = 0;
        boolean isZeroInBetween = false;
        int operations = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                if (isZeroInBetween) {
                    operations += ones;
                    isZeroInBetween = false;
                }

                ones++;
            } else {
                isZeroInBetween = true;
            }
        }
        if (isZeroInBetween) {
            operations += ones;
        }
        return operations;
    }
}
