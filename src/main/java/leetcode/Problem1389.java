package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/create-target-array-in-the-given-order/
 */
public class Problem1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1389 prob = new Problem1389();
        System.out.println(Arrays.toString(prob.createTargetArray(
            new int[]{0,1,2,3,4}, new int[]{0,1,2,2,1}))); // [0,4,1,3,2]
        System.out.println(Arrays.toString(prob.createTargetArray(
            new int[]{1,2,3,4,0}, new int[]{0,1,2,3,0}))); // [0,1,2,3,4]
        System.out.println(Arrays.toString(prob.createTargetArray(
            new int[]{1}, new int[]{0}))); // [1]
    }
}
