package leetcode;

/**
 * https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
 */
public class Problem1758 {
    public int minOperations(String s) {
        int answer = Integer.MAX_VALUE;
        return Math.min(answer, Math.min(getCount(s, false), getCount(s, true)));
    }

    private static int getCount(String s, boolean zero) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((zero && s.charAt(i) == '1') || (!zero && s.charAt(i) == '0')) {
                count++;
            }
            zero = !zero;
        }
        return count;
    }
}
