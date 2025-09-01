package monotonicstack;


/**
 * @author Shanmukha Anirudh
 * @date 01/09/25
 */
public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
        /*if (s.isBlank()) return s;
        int[] freq = new int[26];
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            while (!stack.isEmpty()
                    && c < stack.peek()
                    && freq[stack.peek() - 'a'] > 0
                    && !visited[c - 'a']) {
                visited[stack.pop() - 'a'] = false;
            }

            if (!visited[c - 'a']) {
                stack.push(c);
                visited[c - 'a'] = true;
            }

            freq[c - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return stack.isEmpty() ? "" : sb.reverse().toString();*/
        if (s == null || s.isEmpty()) return "";

        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            freq[idx]--;

            if (visited[idx]) continue;

            while (!sb.isEmpty() && c < sb.charAt(sb.length() - 1) && freq[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(c);
            visited[idx] = true;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("baab"));
    }
}
