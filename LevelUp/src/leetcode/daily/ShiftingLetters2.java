package leetcode.daily;

public class ShiftingLetters2 {
    public static void main(String[] args) {
        int[][] ar = {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};
        String s="abc";
        System.out.println(shiftingLetters(s,ar));
    }

    public static String shiftingLetters(String s, int[][] shifts) {
        if (s == null || s.trim().isEmpty() || shifts == null || shifts.length == 0) return s;
        int n = s.length();
        //using line sweep algorithm
        int[] ar = new int[n];
        for (int[] shift : shifts) {
            if (shift[2] == 1) {
                ar[shift[0]]++;
                if (shift[1] + 1 < n) {
                    ar[shift[1] + 1]--;
                }
            } else {
                ar[shift[0]]--;
                if (shift[1] + 1 < n) {
                    ar[shift[1] + 1]++;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + ar[i]) % 26;
            if (sum < 0) sum += 26;
            char shifted = (char) ('a' + ((s.charAt(i) - 'a' + sum) % 26));
            result.append(shifted);
        }
        return result.toString();
    }
}
