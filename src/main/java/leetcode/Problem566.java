package leetcode;

/**
 * https://leetcode.com/problems/reshape-the-matrix/
 */
public class Problem566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem566 prob = new Problem566();
        System.out.println(prob.matrixReshape(new int[][]{
            {1, 2},
            {3, 4}
        }, 1, 2)); // [[1,2,3,4]]
        System.out.println(prob.matrixReshape(new int[][]{
            {1, 2},
            {3, 4}
        }, 2, 4)); // [[1],[2],[3],[4]]
        System.out.println(prob.matrixReshape(new int[][]{
            {1, 2},
            {3, 4}
        }, 2, 2)); // [[1,2], [3,4]]
    }
}
