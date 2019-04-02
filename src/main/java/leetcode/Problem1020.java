package leetcode;

/**
 * https://leetcode.com/problems/number-of-enclaves/
 */
public class Problem1020 {
    public int numEnclaves(int[][] A) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1020 prob = new Problem1020();
        System.out.println(prob.numEnclaves(new int[][]{
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        })); // 3
        System.out.println(prob.numEnclaves(new int[][]{
            {0, 1, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0}
        })); // 0
    }
}
