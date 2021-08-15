package leetcode;

/**
 * https://leetcode.com/problems/count-sub-islands/
 */
public class Problem1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1905 prob = new Problem1905();
        System.out.println(prob.countSubIslands(new int[][]{
            {1,1,1,0,0},
            {0,1,1,1,1},
            {0,0,0,0,0},
            {1,0,0,0,0},
            {1,1,0,1,1}
        }, new int[][]{
            {1,1,1,0,0},
            {0,0,1,1,1},
            {0,1,0,0,0},
            {1,0,1,1,0},
            {0,1,0,1,0}
        })); // 3
        System.out.println(prob.countSubIslands(new int[][]{
            {1,0,1,0,1},
            {1,1,1,1,1},
            {0,0,0,0,0},
            {1,1,1,1,1},
            {1,0,1,0,1}
        }, new int[][]{
            {0,0,0,0,0},
            {1,1,1,1,1},
            {0,1,0,1,0},
            {0,1,0,1,0},
            {1,0,0,0,1}
        })); // 2
    }
}
