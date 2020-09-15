package leetcode;

/**
 * https://leetcode.com/problems/special-positions-in-a-binary-matrix/
 */
public class Problem1582 {
    public int numSpecial(int[][] mat) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1582 prob = new Problem1582();
        System.out.println(prob.numSpecial(new int[][]{
            {1, 0, 0},
            {0, 0, 1},
            {1, 0, 0}
        })); // 1
        System.out.println(prob.numSpecial(new int[][]{
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        })); // 3
        System.out.println(prob.numSpecial(new int[][]{
            {0, 0, 0, 1},
            {1, 0, 0, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        })); // 2
        System.out.println(prob.numSpecial(new int[][]{
            {0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1}
        })); // 3
    }
}
