package greedy;

public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        int twenties = 0;
        for (int bill : bills) {
            if (bill == 5)
                fives++;
            else if (bill == 10) {
                tens++;
                fives--;
                if (fives < 0)
                    return false;
            } else {
                twenties++;
                if (tens <= 0 && fives < 3)
                    return false;
                if (tens <= 0) {
                    fives -= 3;
                } else {
                    tens--;
                    if (fives <= 0)
                        return false;
                    fives--;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5, 5, 10, 10, 20};
        System.out.println(lemonadeChange(bills));
    }
}
