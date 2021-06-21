package leetcode;

/**
 * https://leetcode.com/problems/largest-odd-number-in-string/
 */
public class Problem1903 {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            int n = num.charAt(i) - '0';
            if (n % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
