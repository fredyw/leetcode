package leetcode;

/**
 * https://leetcode.com/problems/path-with-maximum-gold/
 */
public class Problem1219 {
    public int getMaximumGold(int[][] grid) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1219 prob = new Problem1219();
        System.out.println(prob.getMaximumGold(new int[][]{
            {0, 6, 0},
            {5, 8, 7},
            {0, 9, 0}
        })); // 24
        System.out.println(prob.getMaximumGold(new int[][]{
            {1, 0, 7},
            {2, 0, 6},
            {3, 4, 5},
            {0, 3, 0},
            {9, 0, 20}
        })); // 28
    }
}
