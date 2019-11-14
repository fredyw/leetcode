package leetcode;

/**
 * https://leetcode.com/problems/number-of-closed-islands/
 */
public class Problem1254 {
    public int closedIsland(int[][] grid) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1254 prob = new Problem1254();
        System.out.println(prob.closedIsland(new int[][]{
            {1,1,1,1,1,1,1,0},
            {1,0,0,0,0,1,1,0},
            {1,0,1,0,1,1,1,0},
            {1,0,0,0,0,1,0,1},
            {1,1,1,1,1,1,1,0}
        })); // 2
        System.out.println(prob.closedIsland(new int[][]{
            {0,0,1,0,0},
            {0,1,0,1,0},
            {0,1,1,1,0}
        })); // 1
        System.out.println(prob.closedIsland(new int[][]{
            {1,1,1,1,1,1,1},
            {1,0,0,0,0,0,1},
            {1,0,1,1,1,0,1},
            {1,0,1,0,1,0,1},
            {1,0,1,1,1,0,1},
            {1,0,0,0,0,0,1},
            {1,1,1,1,1,1,1}
        })); // 2
        System.out.println(prob.closedIsland(new int[][]{
            {1,1,1,1,1,1,1,0},
            {1,1,0,1,0,1,1,0},
            {1,0,1,0,1,1,1,0},
            {1,1,0,1,0,1,0,1},
            {1,1,1,1,1,1,1,0}
        })); // 7
    }
}
