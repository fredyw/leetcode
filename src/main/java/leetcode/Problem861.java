package leetcode;

/**
 * https://leetcode.com/problems/score-after-flipping-matrix/
 */
public class Problem861 {
    public int matrixScore(int[][] A) {
        int nRow = A.length;
        int nCol = A.length > 0 ? A[0].length : 0;
        int[] score = score(A);
        for (int col = 0; col < nCol; col++) {
            String s = "";
            int[] newCol = new int[nRow];
            for (int row = 0; row < nRow; row++) {
                if (A[row][col] == 0) {

                } else {

                }
            }
        }
        for (int row = 0; row < nRow; row++) {
            String s = "";
            int[] newRow = new int[nCol];
            for (int col = 0; col < nCol; col++) {
                if (A[row][col] == 0) {
                    s += "1";
                    newRow[col] = 1;
                } else {
                    s += "0";
                    newRow[col] = 0;
                }
            }
            int val = Integer.parseInt(s, 2);
            if (val > score[row]) {
                score[row] = val;
                A[row] = newRow;
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
            String s = "";
            for (int j = 0; j < a[i].length; j++) {
                s += a[i][j];
            }
            score[i] = Integer.parseInt(s, 2);
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
