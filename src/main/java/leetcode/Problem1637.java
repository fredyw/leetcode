package leetcode;

/**
 * https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
 */
public class Problem1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1637 prob = new Problem1637();
        System.out.println(prob.maxWidthOfVerticalArea(new int[][]{
            {8,7},{9,9},{7,4},{9,7}
        })); // 1
        System.out.println(prob.maxWidthOfVerticalArea(new int[][]{
            {9,9},{7,4},{9,7}
        })); // 2
        System.out.println(prob.maxWidthOfVerticalArea(new int[][]{
            {3,1},{9,0},{1,0},{1,4},{5,3},{8,8}
        })); // 3
    }
}
