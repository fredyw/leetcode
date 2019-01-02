package leetcode;

/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 */
public class Problem132 {
    public int minCut(String s) {
        Integer[][] memo = new Integer[s.length() + 1][s.length() + 1];
        return minCut(s, 0, 1, memo);
    }

    private static int minCut(String s, int i, int j, Integer[][] memo) {
        if (i == s.length() || j > s.length()) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        String sub = s.substring(i, j);
        int min = Integer.MAX_VALUE;
        if (isPalindrome(sub)) {
            int val = minCut(s, j, j + 1, memo);
            if (val == Integer.MAX_VALUE) {
                min = 0;
            } else {
                min = Math.min(min, val + 1);
            }
        }
        min = Math.min(min, minCut(s, i, j + 1, memo));
        memo[i][j] = min;
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
}
