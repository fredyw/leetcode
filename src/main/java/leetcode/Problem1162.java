package leetcode;

/**
 * https://leetcode.com/problems/as-far-from-land-as-possible/
 */
public class Problem1162 {
    public int maxDistance(int[][] grid) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1162 prob = new Problem1162();
        System.out.println(prob.maxDistance(new int[][]{
            {1,0,1},
            {0,0,0},
            {1,0,1}
        })); //
        System.out.println(prob.maxDistance(new int[][]{
            {1,0,0},
            {0,0,0},
            {0,0,0}
        })); // 4
    }
}
