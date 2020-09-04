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
        String str = "";
        for (char c : s.toCharArray()) {
            str += c == '0' ? '1' : '0';
        }
        return str;
    }

    public static void main(String[] args) {
        Problem1545 prob = new Problem1545();
        System.out.println(prob.findKthBit(3, 1)); // "0"
        System.out.println(prob.findKthBit(4, 11)); // "1"
        System.out.println(prob.findKthBit(1, 1)); // "0"
        System.out.println(prob.findKthBit(2, 3)); // "1"
        System.out.println(prob.findKthBit(20, 1048575)); // "1"
    }
}
