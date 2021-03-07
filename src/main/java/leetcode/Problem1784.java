package leetcode;

/**
 * https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 */
public class Problem1784 {
    public boolean checkOnesSegment(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '1') {
            i++;
        }
        for (; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                return false;
            }
        }
        return true;
    }
}
