package leetcode;

/**
 * https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
 */
public class Problem1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1779 prob = new Problem1779();
        System.out.println(prob.nearestValidPoint(3, 4, new int[][]{{1,2},{3,1},{2,4},{2,3},{4,4}})); // 2
        System.out.println(prob.nearestValidPoint(3, 4, new int[][]{{3,4}})); // 0
        System.out.println(prob.nearestValidPoint(3, 4, new int[][]{{2,3}})); // -1
    }
}
