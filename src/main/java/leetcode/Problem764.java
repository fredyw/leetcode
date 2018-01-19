package leetcode;

/**
 * https://leetcode.com/problems/largest-plus-sign/
 */
public class Problem764 {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem764 prob = new Problem764();
        System.out.println(prob.orderOfLargestPlusSign(5, new int[][]{
            {4, 2}
        })); // 2
        System.out.println(prob.orderOfLargestPlusSign(2, new int[][]{
        })); // 1
        System.out.println(prob.orderOfLargestPlusSign(1, new int[][]{
            {0, 0}
        })); // 0
    }
}
