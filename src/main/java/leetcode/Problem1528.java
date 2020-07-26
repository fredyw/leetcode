package leetcode;

/**
 * https://leetcode.com/problems/shuffle-string/
 */
public class Problem1528 {
    public String restoreString(String s, int[] indices) {
        char[] answer = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            answer[indices[i]] = s.charAt(i);
        }
        return new String(answer);
    }
}
