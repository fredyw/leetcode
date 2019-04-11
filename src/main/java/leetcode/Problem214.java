package leetcode;

/**
 * https://leetcode.com/problems/shortest-palindrome/
 */
public class Problem214 {
    public String shortestPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        int k = j;
        String prefix = "";
        outer: while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                for (int x = k; x >= j; x--) {
                    prefix += s.charAt(x);
                    if (isPalindrome(prefix + s)) {
                        break outer;
                    }
                }
                i = 0;
                j--;
                k = j;
            } else {
                i++;
                j--;
            }
        }
        return prefix + s;
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem214 prob = new Problem214();
        System.out.println(prob.shortestPalindrome("aacecaaa")); // "aaacecaaa"
        System.out.println(prob.shortestPalindrome("abcd")); // "dcbabcd"
        System.out.println(prob.shortestPalindrome("aabaa")); // "aabaa"
        System.out.println(prob.shortestPalindrome("aaaa")); // "aaaa"
        System.out.println(prob.shortestPalindrome("aaba")); // "abaaba"
        System.out.println(prob.shortestPalindrome("aababa")); // "ababaababa"
    }
}