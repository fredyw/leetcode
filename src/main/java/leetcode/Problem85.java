package leetcode;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class Problem85 {
    public int maximalRectangle(char[][] matrix) {
        return 0;
    }

    public static void main(String[] args) {
        Problem85 prob = new Problem85();
        System.out.println(prob.maximalRectangle(new char [][]{
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'},
        })); // 6
    }
}
