package leetcode;

/**
 * https://leetcode.com/problems/edit-distance/
 */
public class Problem72 {
    public int minDistance(String word1, String word2) {
        Integer[][] memo = new Integer[word1.length() + 1][word2.length() + 1];
        return minDistance(word1, word2, word1.length(), word2.length(), memo);
    }

    private int minDistance(String word1, String word2, int i, int j, Integer[][] memo) {
        if (memo[i][j] != null) {
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
        // insert
        int a = minDistance(word1, word2, i, j - 1, memo);
        // delete
        int b = minDistance(word1, word2, i - 1, j, memo);
        // replace
        int c = minDistance(word1, word2, i - 1, j - 1, memo);
        int min = 1 + Math.min(a, Math.min(b, c));
        memo[i][j] = min;
        return min;
    }
}
