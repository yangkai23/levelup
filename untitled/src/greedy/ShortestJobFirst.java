package greedy;

import java.util.Arrays;

public class ShortestJobFirst {
    public static long solve(int[] bt) {
        Arrays.sort(bt);
        int waitTime = 0;
        int t = 0;
        for (int j : bt) {
            waitTime += t;
            t += j;
        }
        return waitTime / bt.length;
    }

    public static void main(String[] args) {
        int[] bt = {4, 1, 3, 7, 2};
        System.out.println(solve(bt));
    }
}
