package leetcode;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class Problem378 {
    public int kthSmallest(int[][] matrix, int k) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int row = (k - 1) / rowSize;
        int col = (k - 1) - (row * colSize);
        // TODO
        return matrix[row][col];
    }

    public static void main(String[] args) {
        Problem378 prob = new Problem378();
        for (int i = 0; i < 9; i++) {
            System.out.println(prob.kthSmallest(new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
            }, i + 1));
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(prob.kthSmallest(new int[][]{
                {1, 2},
                {1, 3},
            }, i + 1));
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(prob.kthSmallest(new int[][]{
                {1, 1, 1},
                {1, 1, 3},
                {1, 2, 3},
            }, i + 1));
        }
    }
}
