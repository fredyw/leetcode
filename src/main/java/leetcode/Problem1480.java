package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class Problem1480 {
    public int[] runningSum(int[] nums) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1480 prob = new Problem1480();
        System.out.println(Arrays.toString(prob.runningSum(new int[]{1,2,3,4}))); // [1,3,6,10]
        System.out.println(Arrays.toString(prob.runningSum(new int[]{1,1,1,1,1}))); // [1,2,3,4,5]
        System.out.println(Arrays.toString(prob.runningSum(new int[]{3,1,2,10,1}))); // [3,4,6,16,17]
    }
}
