package leetcode;

/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 */
public class Problem132 {
    public int minCut(String s) {
        return minCut(s, 0, 1, s.length());
    }

    private static int minCut(String s, int i, int j, int max) {
        if (i == s.length() || j == s.length()) {
            return max;
        }
        String sub = s.substring(i, j);
        int min = max;
        if (isPalindrome(sub)) {
            min = Math.min(min, minCut(s, j, j + 1, max) - 1);
        }
        min = Math.min(min, minCut(s, i, j + 1, max));
        return min;
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
        Problem132 prob = new Problem132();
        System.out.println(prob.minCut("aab")); // 1
        System.out.println(prob.minCut("aaa")); // 0
        System.out.println(prob.minCut("bbaaaaabb")); // 0
        System.out.println(prob.minCut("baaaaabb")); // 1
    }
}
