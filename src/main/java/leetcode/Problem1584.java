package leetcode;

/**
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 */
public class Problem1584 {
    public int minCostConnectPoints(int[][] points) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1584 prob = new Problem1584();
        System.out.println(prob.minCostConnectPoints(new int[][]{
            {0,0},{2,2},{3,10},{5,2},{7,0}
        })); // 20
        System.out.println(prob.minCostConnectPoints(new int[][]{
            {3,12},{-2,5},{-4,1}
        })); // 18
        System.out.println(prob.minCostConnectPoints(new int[][]{
            {0,0},{1,1},{1,0},{-1,1}
        })); // 4
        System.out.println(prob.minCostConnectPoints(new int[][]{
            {-1000000,-1000000},{1000000,1000000}
        })); // 4000000
        System.out.println(prob.minCostConnectPoints(new int[][]{
            {0,0}
        })); // 0
    }
}
