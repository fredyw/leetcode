package leetcode;

/**
 * https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
 */
public class Problem1886 {
    public boolean findRotation(int[][] mat, int[][] target) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1886 prob = new Problem1886();
        System.out.println(prob.findRotation(new int[][]{
            {0, 1},
            {1, 0}
        }, new int[][]{
            {1, 0},
            {0, 1}
        })); // true
        System.out.println(prob.findRotation(new int[][]{
            {0, 1},
            {1, 1}
        }, new int[][]{
            {1, 0},
            {0, 1}
        })); // false
        System.out.println(prob.findRotation(new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        }, new int[][]{
            {1, 1, 1},
            {0, 1, 0},
            {0, 0, 0}
        })); // true
    }
}
