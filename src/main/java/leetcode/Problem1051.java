package leetcode;

/**
 * https://leetcode.com/problems/height-checker/
 */
public class Problem1051 {
    public int heightChecker(int[] heights) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1051 prob = new Problem1051();
        System.out.println(prob.heightChecker(new int[]{1, 1, 4, 2, 1, 3})); // 3
        System.out.println(prob.heightChecker(new int[]{1, 1, 4, 2, 3, 1})); // 2
        System.out.println(prob.heightChecker(new int[]{1, 1, 2, 2, 3, 1})); // 3
    }
}
