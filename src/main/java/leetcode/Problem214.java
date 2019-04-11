package leetcode;

/**
 * https://leetcode.com/problems/shortest-palindrome/
 */
public class Problem214 {
    public String shortestPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        String prefix = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(0, s.length() - i).equals(reversed.substring(i))) {
                break;
            }
            prefix += reversed.charAt(i);
        }
        return prefix + s;
    }
}