package daily;

/**
 * @author Anirudh
 * @since 10/11/25
 */
public class CountOperationsToObtainZero {
    public static void main(String[] args) {
        System.out.println(countOperations(10,10));
    }
    public static int countOperations(int num1, int num2) {
        int count = 0;

        while (num1 != 0 && num2 != 0) {
            if (num2 > num1) {
                int temp = num1 + num2;
                num1 = temp - num1;
                num2 = temp - num2;
            }
            int d = num1 / num2;
            num1 = num1%num2;
            count += d;

        }
        return count;
    }
}
