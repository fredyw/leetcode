package leetcode;

/**
 * https://leetcode.com/problems/distinct-subsequences/
 */
public class Problem115 {
    public int numDistinct(String s, String t) {
        int[][] memo = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return numDistinct(s, t, 0, 0, memo);
    }

    private static int numDistinct(String s, String t, int i, int j, int[][] memo) {
        if (i >= s.length() || j >= t.length()) {
            return 0;
        }
        int val = (s.charAt(i) == t.charAt(j)) ? 1 : 0;
        int a = numDistinct(s, t, i + 1, j, memo) + val;
        int b = numDistinct(s, t, i + 1, j + 1, memo);
        int max = Math.max(a, b);
        return max;
    }

    public static void main(String[] args) {
        Problem115 prob = new Problem115();
        System.out.println(prob.numDistinct("rabbbit", "rabbit")); // 3
        System.out.println(prob.numDistinct("abc", "def")); // 0
        System.out.println(prob.numDistinct("defaxc", "abc")); // 0
        System.out.println(prob.numDistinct("faxbmcd", "abc")); // 1
    }
}
