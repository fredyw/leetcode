package leetcode;

/**
 * https://leetcode.com/problems/maximal-square/
 */
public class Problem221 {
    public int maximalSquare(char[][] matrix) {
        // TODO:
        return 0;
    }

    public static void main(String[] args) {
        Problem221 prob = new Problem221();
        int result = prob.maximalSquare(new char[][]{
           new char[]{'1', '0', '1', '0', '0'},
           new char[]{'1', '0', '1', '1', '1'},
           new char[]{'1', '1', '1', '1', '1'},
           new char[]{'1', '0', '0', '1', '0'},
        });
        System.out.println(result); // 4
    }
}
