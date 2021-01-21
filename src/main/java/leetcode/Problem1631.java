package leetcode;

/**
 * https://leetcode.com/problems/path-with-minimum-effort/
 */
public class Problem1631 {
    public int minimumEffortPath(int[][] heights) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1631 prob = new Problem1631();
        System.out.println(prob.minimumEffortPath(new int[][]{
            {1,2,2},{3,8,2},{5,3,5}
        })); // 2
        System.out.println(prob.minimumEffortPath(new int[][]{
            {1,2,3},{3,8,4},{5,3,5}
        })); // 1
        System.out.println(prob.minimumEffortPath(new int[][]{
            {1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}
        })); // 0
    }
}
