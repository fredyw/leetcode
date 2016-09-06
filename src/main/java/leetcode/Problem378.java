package leetcode;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class Problem378 {
    public int kthSmallest(int[][] matrix, int k) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem378 prob = new Problem378();
        System.out.println(prob.kthSmallest(new int[][]{
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        }, 8)); // 13
    }
}
