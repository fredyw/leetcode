package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
 */
public class Problem1743 {
    public int[] restoreArray(int[][] adjacentPairs) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1743 prob = new Problem1743();
        System.out.println(Arrays.toString(prob.restoreArray(new int[][]{
            {2,1},{3,4},{3,2}
        }))); // [1,2,3,4]
        System.out.println(Arrays.toString(prob.restoreArray(new int[][]{
            {4,-2},{1,4},{-3,1}
        }))); // [-2,4,1,-3]
        System.out.println(Arrays.toString(prob.restoreArray(new int[][]{
            {100000,-100000}
        }))); // [100000,-100000]
    }
}
