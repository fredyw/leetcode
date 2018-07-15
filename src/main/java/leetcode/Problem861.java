package leetcode;

/**
 * https://leetcode.com/problems/score-after-flipping-matrix/
 */
public class Problem861 {
    public int matrixScore(int[][] A) {
        int nRow = A.length;
        int nCol = A.length > 0 ? A[0].length : 0;
        int[] score = score(A);
        for (int row = 0; row < nRow; row++) {
            for (int col = 0; col < nCol; col++) {
            }
        }
        for (int col = 0; col < nCol; col++) {
            for (int row = 0; row < nRow; row++) {
            }
        }
        int totalScore = 0;
        for (int s : score) {
            totalScore += s;
        }
        return totalScore;
    }

    private static int[] score(int[][] a) {
        int[] score = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int s = 0;
            for (int j = 0; j < a[i].length; j++) {
                s += a[i][j] << a[i].length - j - 1;
            }
            score[i] = s;
        }
        return score;
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
