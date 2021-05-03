package leetcode;

/**
 * https://leetcode.com/problems/replace-all-digits-with-characters/
 */
public class Problem1844 {
    public String replaceDigits(String s) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                answer.append(s.charAt(i));
            } else {
                answer.append(shift(s.charAt(i - 1), s.charAt(i) - '0'));
            }
        }
        return answer.toString();
    }

    private static char shift(char c, int x) {
        return (char) (c + x);
    }
}
