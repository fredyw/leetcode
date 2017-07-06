package leetcode;

/**
 * https://leetcode.com/problems/sum-of-square-numbers/
 */
public class Problem633 {
    public boolean judgeSquareSum(int c) {
        if (c == 0) {
            return true;
        }
        for (int i = 1; i <= Math.sqrt(c); i++) {
            int a = i * i;
            if (a > c) {
                break;
            }
            double b = Math.sqrt(c - a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }
}
