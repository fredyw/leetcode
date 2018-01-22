package leetcode;

/**
 * https://leetcode.com/problems/toeplitz-matrix/
 */
public class Problem766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem766 prob = new Problem766();
        System.out.println(prob.isToeplitzMatrix(new int[][]{
            {1, 2, 3, 4},
            {5, 1, 2, 3},
            {9, 5, 1, 2}
        })); // true
        System.out.println(prob.isToeplitzMatrix(new int[][]{
            {1, 2},
            {2, 2}
        })); // false
    }
}
