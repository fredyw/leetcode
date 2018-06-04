package leetcode;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 */
public class Problem844 {
    public boolean backspaceCompare(String S, String T) {
        return finalString(S).equals(finalString(T));
    }

    private static String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (sb.length() - 1 >= 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
