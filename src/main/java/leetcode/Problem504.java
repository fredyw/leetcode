package leetcode;

/**
 * https://leetcode.com/problems/base-7/
 */
public class Problem504 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        boolean negative = false;
        if (num < 0) {
            num *= -1;
            negative = true;
        }
        while (num > 0) {
            result.append(num % 7);
            num /= 7;
        }
        if (negative) {
            result.append("-");
            return result.reverse().toString();
        }
        return result.reverse().toString();
    }
}
