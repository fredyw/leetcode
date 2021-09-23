package leetcode;

/**
 * https://leetcode.com/problems/maximum-compatibility-score-sum/
 */
public class Problem1947 {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1947 prob = new Problem1947();
        System.out.println(prob.maxCompatibilitySum(new int[][]{
            {1,1,0},{1,0,1},{0,0,1}
        }, new int[][]{
            {1,0,0},{0,0,1},{1,1,0}
        })); // 8
        System.out.println(prob.maxCompatibilitySum(new int[][]{
            {0,0},{0,0},{0,0}
        }, new int[][]{
            {1,1},{1,1},{1,1}
        })); // 0
    }
}
