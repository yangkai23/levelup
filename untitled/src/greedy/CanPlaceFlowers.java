package greedy;

/**
 * @author Anirudh
 * @since 08/10/25
 */
public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 0, 1};
        System.out.println(canPlaceFlowers(flowerbed, 1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length < 1)
            return false;
        if (flowerbed.length == 1 && flowerbed[0] == 0)
            return true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0)
                return true;
            if (flowerbed[i] == 0 &&
                    (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)
            ) {
                n--;
                flowerbed[i] = 1;
            }

        }
        return n <= 0;
    }
}
