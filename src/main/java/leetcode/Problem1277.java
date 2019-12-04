package leetcode;

/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 */
public class Problem1277 {
    public int countSquares(int[][] matrix) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1277 prob = new Problem1277();
        System.out.println(prob.countSquares(new int[][]{
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1}
        })); // 15
        System.out.println(prob.countSquares(new int[][]{
            {1, 0, 1},
            {1, 1, 0},
            {1, 1, 0}
        })); // 7
    }
}
