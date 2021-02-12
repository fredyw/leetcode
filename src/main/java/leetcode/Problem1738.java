package leetcode;

/**
 * https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/
 */
public class Problem1738 {
    public int kthLargestValue(int[][] matrix, int k) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1738 prob = new Problem1738();
        System.out.println(prob.kthLargestValue(new int[][]{
            {5,2},{1,6}
        }, 1)); // 7
        System.out.println(prob.kthLargestValue(new int[][]{
            {5,2},{1,6}
        }, 2)); // 5
        System.out.println(prob.kthLargestValue(new int[][]{
            {5,2},{1,6}
        }, 3)); // 4
        System.out.println(prob.kthLargestValue(new int[][]{
            {5,2},{1,6}
        }, 4)); // 0
    }
}
