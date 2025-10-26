package lld.snakeandladder;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Anirudh
 * @since 26/10/25
 */
public class Dice {
    int diceCount;
    int min = 1;
    int max = 6;


    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int totalSum = 0;
        int diceUsed = diceCount;
        while (diceUsed > 0) {
            totalSum += ThreadLocalRandom.current().nextInt(min, max+1);
            diceUsed--;
        }
        return totalSum;
    }
}
