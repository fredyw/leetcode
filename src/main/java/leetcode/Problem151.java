package leetcode;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class Problem151 {
    public String reverseWords(String s) {
        String[] strs = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i]);
            if (i > 0) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
