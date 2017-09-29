package leetcode;

/**
 * https://leetcode.com/problems/valid-parenthesis-string/
 */
public class Problem678 {
    public boolean checkValidString(String s) {
        int opening = 0;
        int closing = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                opening++;
            } else {
                opening--;
            }
            if (s.charAt(i) == ')') {
                closing--;
            } else {
                closing++;
            }
            if (closing < 0) {
                return false;
            }
            opening = Math.max(opening, 0);
        }
        return opening == 0;
    }
}
