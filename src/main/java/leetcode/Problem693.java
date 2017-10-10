package leetcode;

/**
 * https://leetcode.com/problems/binary-number-with-alternating-bits/
 */
public class Problem693 {
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        boolean zero = false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) == '0') {
                    zero = false;
                } else {
                    zero = true;
                }
            } else {
                if (zero && s.charAt(i) != '0') {
                    return false;
                }
                if (!zero && s.charAt(i) != '1') {
                    return false;
                }
                zero = !zero;
            }
        }
        return true;
    }
}
