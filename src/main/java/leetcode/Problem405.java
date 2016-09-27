package leetcode;

/**
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 */
public class Problem405 {
    public String toHex(int num) {
        StringBuilder result = new StringBuilder();
        int n = num;
        do {
            int m = n & 0xf;
            result.append(hex(m));
            n >>>= 4;
        } while (n > 0);
        result.reverse();
        return result.toString();
    }

    private String hex(int n) {
        if (n >= 0 && n <= 9) {
            return Integer.toString(n);
        }
        if (n == 10) {
            return "a";
        } else if (n == 11) {
            return "b";
        } else if (n == 12) {
            return "c";
        } else if (n == 13) {
            return "d";
        } else if (n == 14) {
            return "e";
        } else if (n == 15) {
            return "f";
        }
        throw new RuntimeException("Not a hex value");
    }
}
