package leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class Problem378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                queue.add(matrix[i][j]);
            }
        }
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = queue.remove();
        }
        return result;
    }
}
