package leetcode;

/**
 * https://leetcode.com/problems/transpose-matrix/
 */
public class Problem868 {
    public int[][] transpose(int[][] A) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem868 prob = new Problem868();
        // [1, 4, 7],
        // [2, 5, 8],
        // [3, 6, 9]
        System.out.println(prob.transpose(new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        }));
        // [1, 4],
        // [2, 5],
        // [3, 6]
        System.out.println(prob.transpose(new int[][]{
            {1, 2, 3},
            {4, 5, 6}
        }));
    }
}
