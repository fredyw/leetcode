package leetcode;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class Problem171 {
    public int titleToNumber(String s) {
        int n = 0;
        int exp = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            n += getNumber(s.charAt(i)) * (int) Math.pow(26, exp);
            exp++;
        }
        return n;
    }

    private int getNumber(char c) {
        return c - 64;
    }
}
