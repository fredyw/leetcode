package leetcode;

/**
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 */
public class Problem1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1376 prob = new Problem1376();
        System.out.println(prob.numOfMinutes(1, 0, new int[]{-1}, new int[]{0})); // 0
        System.out.println(prob.numOfMinutes(6, 2, new int[]{2,2,-1,2,2,2}, new int[]{0,0,1,0,0,0})); // 1
        System.out.println(prob.numOfMinutes(7, 6, new int[]{1,2,3,4,5,6,-1}, new int[]{0,6,5,4,3,2,1})); // 21
        System.out.println(prob.numOfMinutes(15, 0, new int[]{-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6}, new int[]{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0})); // 3
        System.out.println(prob.numOfMinutes(4, 2, new int[]{3,3,-1,2}, new int[]{0,0,162,914})); // 1076
    }
}
