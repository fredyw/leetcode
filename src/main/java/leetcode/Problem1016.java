package leetcode;

/**
 * https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/
 */
public class Problem1016 {
    public boolean queryString(String S, int N) {
        for (int i = N; i >= 1; i--) {
            String s = Integer.toBinaryString(i);
            if (!S.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
