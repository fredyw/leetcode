package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/
 */
public class Problem1253 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1253 prob = new Problem1253();
        System.out.println(prob.reconstructMatrix(2, 1, new int[]{1, 1, 1})); // [[1,1,0],[0,0,1]]
        System.out.println(prob.reconstructMatrix(2, 3, new int[]{2,2,1,1})); // []
        System.out.println(prob.reconstructMatrix(5, 5, new int[]{2,1,2,0,1,0,1,2,0,1})); // [[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
    }
}
