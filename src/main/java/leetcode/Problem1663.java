package leetcode;

/**
 * https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
 */
public class Problem1663 {
    public String getSmallestString(int n, int k) {
        char[] chars = new char[n];
        for (int i = chars.length - 1, j = 0; i >= 0; i--, j--) {
            // TODO
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Problem1663 prob = new Problem1663();
        System.out.println(prob.getSmallestString(3, 27)); // "aay"
        System.out.println(prob.getSmallestString(5, 73)); // "aaszz"
        System.out.println(prob.getSmallestString(27, 43)); // "aaaaaaaaaaaaaaaaaaaaaaaaaaq"
        System.out.println(prob.getSmallestString(28, 43)); // "aaaaaaaaaaaaaaaaaaaaaaaaaap"
    }
}
