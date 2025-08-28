package twopointers;

/**
 * @author Shanmukha Anirudh
 * @date 28/08/25
 */
public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] M = {{0, 1, 1, 0}, {0, 0, 0, 0}, {1, 1, 0, 0}, {0, 1, 1, 0}};
        System.out.println(celebrity(M));
    }

    public static int celebrity(int[][] ar) {
        int top = 0;
        int down = ar.length - 1;
        while (top < down) {
            if (ar[top][down] == 1)
                top++;
            else if (ar[down][top] == 1)
                down--;
            else {
                top++;
                down--;
            }
        }
        if (top > down)
            return -1;
        for (int i = 0; i < ar.length; i++) {
            if (i == top) continue;

            if (ar[top][i] != 0 || ar[i][top] != 1)
                return -1;

        }
        return top;
    }
}
