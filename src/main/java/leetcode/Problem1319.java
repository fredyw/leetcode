package leetcode;

/**
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 */
public class Problem1319 {
    public int makeConnected(int n, int[][] connections) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1319 prob = new Problem1319();
        System.out.println(prob.makeConnected(4, new int[][]{{0,1},{0,2},{1,2}})); // 1
        System.out.println(prob.makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}})); // 2
        System.out.println(prob.makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2}})); // -1
        System.out.println(prob.makeConnected(5, new int[][]{{0,1},{0,2},{3,4},{2,3}})); // 0
    }
}
