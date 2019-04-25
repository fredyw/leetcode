package leetcode;

/**
 * https://leetcode.com/problems/unique-paths-iii/
 */
public class Problem980 {
    public int uniquePathsIII(int[][] grid) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem980 prob = new Problem980();
        System.out.println(prob.uniquePathsIII(new int[][]{
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 2, -1}
        })); // 2
        System.out.println(prob.uniquePathsIII(new int[][]{
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 2}
        })); // 4
        System.out.println(prob.uniquePathsIII(new int[][]{
            {0, 1},
            {2, 0}
        })); // 0
    }
}
