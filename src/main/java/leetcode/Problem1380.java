package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/lucky-numbers-in-a-matrix/
 */
public class Problem1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1380 prob = new Problem1380();
        System.out.println(prob.luckyNumbers(new int[][]{
            {3, 7, 8},
            {9, 11, 13},
            {15, 16, 17}
        })); // [15]
        System.out.println(prob.luckyNumbers(new int[][]{
            {1, 10, 4, 2},
            {9, 3, 8, 7},
            {15, 16, 17, 12}
        })); // [12]
        System.out.println(prob.luckyNumbers(new int[][]{
            {7, 8},
            {1, 2},
        })); // [7]
    }
}
