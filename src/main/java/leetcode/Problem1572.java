package leetcode;

/**
 * https://leetcode.com/problems/matrix-diagonal-sum/
 */
public class Problem1572 {
    public int diagonalSum(int[][] mat) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1572 prob = new Problem1572();
        System.out.println(prob.diagonalSum(new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9}
        })); // 25
        System.out.println(prob.diagonalSum(new int[][]{
            {1,1,1,1},
            {1,1,1,1},
            {1,1,1,1},
            {1,1,1,1},
        })); // 7
        System.out.println(prob.diagonalSum(new int[][]{
            {5},
        })); // 5
    }
}
