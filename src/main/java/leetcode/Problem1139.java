package leetcode;

/**
 * https://leetcode.com/problems/largest-1-bordered-square/
 */
public class Problem1139 {
    public int largest1BorderedSquare(int[][] grid) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1139 prob = new Problem1139();
        System.out.println(prob.largest1BorderedSquare(new int[][]{
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        })); // 9
        System.out.println(prob.largest1BorderedSquare(new int[][]{
            {1, 1, 0, 0},
        })); // 1
        System.out.println(prob.largest1BorderedSquare(new int[][]{
            {1, 1, 1, 1},
        })); // 1
        System.out.println(prob.largest1BorderedSquare(new int[][]{
            {1, 1, 1, 1},
            {1, 1, 1, 1}
        })); // 4
        System.out.println(prob.largest1BorderedSquare(new int[][]{
            {1, 1, 1, 1},
            {1, 0, 0, 1},
            {1, 1, 1, 1},
        })); // 1
        System.out.println(prob.largest1BorderedSquare(new int[][]{
            {1, 1, 1, 1},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {1, 1, 1, 1},
        })); // 16
    }
}
