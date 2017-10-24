package leetcode;

/**
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 */
public class Problem712 {
    public int minimumDeleteSum(String s1, String s2) {
        Integer[][] memo = new Integer[s1.length() + 1][s2.length() + 1];
        return minimumDeleteSum(s1, s2, 0, 0, memo);
    }

    private static int minimumDeleteSum(String s1, String s2, int i, int j, Integer[][] memo) {
        if (i == s1.length() && j == s2.length()) {
            return 0;
        }
        if (i == s1.length()) {
            int sum = 0;
            for (int x = j; x < s2.length(); x++) {
                sum += s2.charAt(x);
            }
            return sum;
        }
        if (j == s2.length()) {
            int sum = 0;
            for (int x = i; x < s1.length(); x++) {
                sum += s1.charAt(x);
            }
            return sum;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return minimumDeleteSum(s1, s2, i + 1, j + 1, memo);
        }
        int a = minimumDeleteSum(s1, s2, i + 1, j, memo) + s1.charAt(i);
        int b = minimumDeleteSum(s1, s2, i, j + 1, memo) + s2.charAt(j);
        int min = Math.min(a, b);
        memo[i][j] = min;
        return min;
    }
}
