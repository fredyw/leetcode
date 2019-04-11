package leetcode;

/**
 * https://leetcode.com/problems/shortest-palindrome/
 */
public class Problem214 {
    public String shortestPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        String answer = s;
        while (i < j) {
            // TODO
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem214 prob = new Problem214();
//        System.out.println(prob.shortestPalindrome("aacecaaa")); // "aaacecaaa"
        System.out.println(prob.shortestPalindrome("abcd")); // "dcbabcd"
//        System.out.println(prob.shortestPalindrome("aabaa")); // "aabaa"
//        System.out.println(prob.shortestPalindrome("aaaa")); // "aaaa"
//        System.out.println(prob.shortestPalindrome("aaba")); // "abaaba"
//        System.out.println(prob.shortestPalindrome("aababa")); // "ababaababa"
    }
}