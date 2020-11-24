package leetcode;

/**
 * https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
 */
public class Problem1663 {
    public String getSmallestString(int n, int k) {
        char[] chars = new char[n];
        int remaining = k;
        for (int i = chars.length - 1; i >= 0; i--) {
            int x = remaining - 26 - i;
            if (x < 0) {
                x = remaining - i;
                chars[i] = (char) (x + 'a' - 1);
                remaining -= x;
            } else {
                chars[i] = 'z';
                remaining -= 'z' - 'a' + 1;
            }
        }
        return new String(chars);
    }
}
