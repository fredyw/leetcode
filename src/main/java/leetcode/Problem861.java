package leetcode;

/**
 * https://leetcode.com/problems/score-after-flipping-matrix/
 */
public class Problem861 {
    public int matrixScore(int[][] A) {
        int nRow = A.length;
        int nCol = A.length > 0 ? A[0].length : 0;
        int[] scores = new int[nRow];
        for (int row = 0; row < nRow; row++) {
            int origScore = 0;
            int flipScore = 0;
            for (int col = 0; col < nCol; col++) {
                origScore += A[row][col] << nCol - col - 1;
                flipScore += (A[row][col] ^ 1) << nCol - col - 1;
            }
            scores[row] = (origScore > flipScore) ? origScore : flipScore;
        }
        int totalScore = 0;
        for (int col = 0; col < nCol; col++) {
            int origScore = 0;
            int flipScore = 0;
            int[] flipScores = new int[nRow];
            for (int row = 0; row < nRow; row++) {
                origScore += scores[row];
                int fs = scores[row] ^ (1 << nCol - col - 1);
                flipScore += fs;
                flipScores[row] = fs;
            }
            if (origScore < flipScore) {
                scores = flipScores;
            }
            totalScore = Math.max(origScore, flipScore);
        }
        return totalScore;
    }
}
