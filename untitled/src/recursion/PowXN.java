package recursion;

/**
 * @author Anirudh
 * @since 01/02/26
 */
public class PowXN {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
    }

    public static double myPow(double x, int n) {

        boolean negative = n * -1 > 0;
        double val = getPow(x, n);
        if (negative) {
            return 1.0 / val;
        }

        return val;
    }

    static double getPow(double x, int n) {
        if (n == 0)
            return 1.0;
        if (n == 1)
            return x;
        if (n % 2 == 0) {
            return getPow(x * x, n / 2);
        }

        return x * getPow(x, n - 1);
    }
}
