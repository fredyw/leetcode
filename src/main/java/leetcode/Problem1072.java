package leetcode;

/**
 * https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/
 */
public class Problem1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1072 prob = new Problem1072();
        System.out.println(prob.maxEqualRowsAfterFlips(new int[][]{
            {0, 1},
            {1, 1}
        })); // 1
        System.out.println(prob.maxEqualRowsAfterFlips(new int[][]{
            {0, 1},
            {1, 0}
        })); // 2
        System.out.println(prob.maxEqualRowsAfterFlips(new int[][]{
            {0, 0, 0},
            {0, 0, 1},
            {1, 1, 0}
        })); // 2
    }
}
