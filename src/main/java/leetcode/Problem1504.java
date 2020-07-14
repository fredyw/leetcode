package leetcode;

/**
 * https://leetcode.com/problems/count-submatrices-with-all-ones/
 */
public class Problem1504 {
    public int numSubmat(int[][] mat) {
        int maxRow = mat.length;
        int maxCol = maxRow > 0 ? mat[0].length : 0;
        int answer = 0;
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (mat[row][col] == 0) {
                    continue;
                }
                answer += numSubmat(mat, maxRow, maxCol, row, col, row, col);
            }
        }
        return answer;
    }

    private static int numSubmat(int[][] mat, int maxRow, int maxCol,
                                 int row1, int col1, int row2, int col2) {
        if (row2 == maxRow || col2 == maxCol) {
            return 0;
        }
        for (int row = row1; row <= row2; row++) {
            if (mat[row][col2] == 0) {
                return 0;
            }
        }
        for (int col = col1; col <= col2; col++) {
            if (mat[row2][col] == 0) {
                return 0;
            }
        }
        System.out.println(row1 + "," + col1 + " -- " + row2 + "," + col2);
        int a = numSubmat(mat, maxRow, maxCol, row1, col1, row2 + 1, col2);
        int b = numSubmat(mat, maxRow, maxCol, row1, col1, row2, col2 + 1);
        int val = a + b + 1;
        return val;
    }

    public static void main(String[] args) {
        Problem1504 prob = new Problem1504();
        System.out.println(prob.numSubmat(new int[][]{
            {1,1},
            {1,1},
        })); // 9
//        System.out.println(prob.numSubmat(new int[][]{
//            {1,0,1},
//            {1,1,0},
//            {1,1,0},
//        })); // 13
//        System.out.println(prob.numSubmat(new int[][]{
//            {0,1,1,0},
//            {0,1,1,1},
//            {1,1,1,0},
//        })); // 24
//        System.out.println(prob.numSubmat(new int[][]{
//            {1,1,1,1,1,1},
//        })); // 21
//        System.out.println(prob.numSubmat(new int[][]{
//            {1,0,1},
//            {0,1,0},
//            {1,0,1},
//        })); // 5
    }
}
