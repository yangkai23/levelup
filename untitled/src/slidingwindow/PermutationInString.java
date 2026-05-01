package slidingwindow;

/**
 * @author Anirudh
 * @since 06/04/26
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if (m > n)
            return false;

        int[] freq = new int[26];

        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0;

        int cnt = 0;

        for (int right = 0; right < n; right++) {

            freq[s2.charAt(right) - 'a']--;

            if (freq[s2.charAt(right) - 'a'] == 0)
                cnt++;

            if (right - left + 1 > m) {
                if (freq[s2.charAt(left) - 'a'] == 0)
                    cnt--;
                freq[s2.charAt(left) - 'a']++;

                left++;
            }

            if (cnt == m)
                return true;
        }

        return false;
    }
}
