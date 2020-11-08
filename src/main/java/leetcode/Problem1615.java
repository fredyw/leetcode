package leetcode;

/**
 * https://leetcode.com/problems/maximal-network-rank/
 */
public class Problem1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1615 prob = new Problem1615();
        System.out.println(prob.maximalNetworkRank(
            4, new int[][]{{0,1},{0,3},{1,2},{1,3}})); // 4
        System.out.println(prob.maximalNetworkRank(
            5, new int[][]{{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}})); // 5
        System.out.println(prob.maximalNetworkRank(
            4, new int[][]{{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}})); // 5
    }
}
