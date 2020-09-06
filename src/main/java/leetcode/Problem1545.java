package leetcode;

/**
 * https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
 */
public class Problem1545 {
    public char findKthBit(int n, int k) {
        String s = "0";
        for (int i = 0; i < n - 1; i++) {
            s = s + "1" + reverse(inverse(s));
            if (s.length() >= k) {
                return s.charAt(k - 1);
            }
        }
        return '0';
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static String inverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c == '0' ? '1' : '0');
        }
        return sb.toString();
    }
}
