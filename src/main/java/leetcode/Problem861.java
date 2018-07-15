package leetcode;

/**
 * https://leetcode.com/problems/score-after-flipping-matrix/
 */
public class Problem861 {
    public int matrixScore(int[][] A) {
        int nRow = A.length;
        int nCol = A.length > 0 ? A[0].length : 0;
        int totalScore = 0;
        int[] score = new int[nRow];
        for (int row = 0; row < nRow; row++) {
            int origScore = 0;
            int flipScore = 0;
            for (int col = 0; col < nCol; col++) {
                origScore += A[row][col] << nCol - col - 1;
                flipScore += (A[row][col] ^ 1) << nCol - col - 1;
            }
            score[row] = (origScore > flipScore) ? origScore : flipScore;
        }
        for (int col = 0; col < nCol; col++) {
            for (int row = 0; row < nRow; row++) {
            }
        }
        for (int s : score) {
            totalScore += s;
        }
        return totalScore;
    }

    public static void main(String[] args) {
        Problem861 prob = new Problem861();
//            {1, 1, 1, 1},
//            {1, 0, 0, 1},
//            {1, 1, 1, 1}
        System.out.println(prob.matrixScore(new int[][]{
            {0, 0, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 0}
        })); // 39
    }
}
