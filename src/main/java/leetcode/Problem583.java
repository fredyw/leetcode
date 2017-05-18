package leetcode;

/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 */
public class Problem583 {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }
        return minDistance(word1, word2, word1.length(), word2.length(), memo);
    }

    private static int minDistance(String word1, String word2, int i, int j, int[][] memo) {
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return minDistance(word1, word2, i - 1, j - 1, memo);
        }
        int a = minDistance(word1, word2, i - 1, j, memo);
        int b = minDistance(word1, word2, i, j - 1, memo);
        int min = 1 + Math.min(a, b);
        memo[i][j] = min;
        return min;
    }
}
