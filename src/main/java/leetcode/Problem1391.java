package leetcode;

/**
 * https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
 */
public class Problem1391 {
    public boolean hasValidPath(int[][] grid) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1391 prob = new Problem1391();
        System.out.println(prob.hasValidPath(new int[][]{
            {1,2,1},{1,2,1}
        })); // false
        System.out.println(prob.hasValidPath(new int[][]{
            {1,1,2}
        })); // false
        System.out.println(prob.hasValidPath(new int[][]{
            {1,1,1,1,1,1,3}
        })); // true
        System.out.println(prob.hasValidPath(new int[][]{
            {2},{2},{2},{2},{2},{2},{6}
        })); // true
    }
}
