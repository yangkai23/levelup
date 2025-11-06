package recursion;

/**
 * @author Anirudh
 * @since 04/11/25
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(7));
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int last = fibonacci(n - 1);
        int slast = fibonacci(n - 2);
        return last + slast;

    }
}
