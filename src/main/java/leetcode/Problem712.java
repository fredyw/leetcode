package leetcode;

/**
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 */
public class Problem712 {
    public int minimumDeleteSum(String s1, String s2) {
        // TODO
        return minimumDeleteSum(s1, s2, s1.length(), s2.length());
    }

    private static int minimumDeleteSum(String s1, String s2, int i, int j) {
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return minimumDeleteSum(s1, s2, i - 1, j - 1);
        }
        int ival = 0;
        if (i < s1.length()) {
            ival = s1.charAt(i);
        }
        int jval = 0;
        if (j < s2.length()) {
            jval = s2.charAt(j);
        }
        int a = minimumDeleteSum(s1, s2, i, j - 1);
        int b = minimumDeleteSum(s1, s2, i - 1, j);
        int min = 1 + Math.min(a, b);
        return min;
    }

    public static void main(String[] args) {
        Problem712 prob = new Problem712();
        System.out.println(prob.minimumDeleteSum("sea", "eat")); // 231
        System.out.println(prob.minimumDeleteSum("delete", "leet")); // 403
    }
}
