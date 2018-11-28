package leetcode;

/**
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 */
public class Problem947 {
    public int removeStones(int[][] stones) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem947 prob = new Problem947();
        System.out.println(prob.removeStones(new int[][]{
            {0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}
        })); // 5
        System.out.println(prob.removeStones(new int[][]{
            {0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}
        })); // 3
        System.out.println(prob.removeStones(new int[][]{
            {0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}, {3, 3}
        })); // 3
        System.out.println(prob.removeStones(new int[][]{
            {0, 0}
        })); // 0
        System.out.println(prob.removeStones(new int[][]{
            {0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}, {3, 0}
        })); // 6
        System.out.println(prob.removeStones(new int[][]{
            {0, 0}, {3, 3}
        })); // 0
        System.out.println(prob.removeStones(new int[][]{
            {0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}
        })); // 3
    }
}
