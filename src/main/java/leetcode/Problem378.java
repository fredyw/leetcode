package leetcode;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class Problem378 {
    public int kthSmallest(int[][] matrix, int k) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int row = (int) Math.ceil(k / rowSize);
        System.out.println("k: " + k);
        System.out.println("rowSize: " + rowSize);
        System.out.println("row: " + row);
        int col = (row * colSize) - k + 1;
        System.out.println("col: " + col);
//        System.out.println("col: " + ((row * colSize)));
        return matrix[row][col];
    }

    public static void main(String[] args) {
        Problem378 prob = new Problem378();
//        System.out.println(prob.kthSmallest(new int[][]{
//            {1, 5, 9},
//            {10, 11, 13},
//            {12, 13, 15}
//        }, 8)); // 13
        System.out.println(prob.kthSmallest(new int[][]{
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        }, 6)); // 13
//        System.out.println(prob.kthSmallest(new int[][]{
//            {1, 5, 9},
//            {10, 11, 13},
//            {12, 13, 15}
//        }, 7)); // 12
    }
}
