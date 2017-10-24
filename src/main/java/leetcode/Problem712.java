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
            return s2.charAt(j);
        }
        if (j == s2.length()) {
            return s1.charAt(i);
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return minimumDeleteSum(s1, s2, i + 1, j + 1, memo);
        }
        int a = minimumDeleteSum(s1, s2, i + 1, j, memo) + s1.charAt(i);
        int b = minimumDeleteSum(s1, s2, i, j + 1, memo) + s2.charAt(j);
        int c = minimumDeleteSum(s1, s2, i + 1, j + 1, memo) + s1.charAt(i) + s2.charAt(j);
        int min = Math.min(a, Math.min(b, c));
        memo[i][j] = min;
        return min;
    }

    public static void main(String[] args) {
        Problem712 prob = new Problem712();
        System.out.println(prob.minimumDeleteSum("sea", "eat")); // 231
        System.out.println(prob.minimumDeleteSum("delete", "leet")); // 403
    }
}
