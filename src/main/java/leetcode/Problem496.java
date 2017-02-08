package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 */
public class Problem496 {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        // TODO
        return new int[0];
    }

    public static void main(String[] args) {
        Problem496 prob = new Problem496();
        System.out.println(Arrays.toString(prob.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}))); // [-1,3,-1]
        System.out.println(Arrays.toString(prob.nextGreaterElement(new int[]{4, 1, 3}, new int[]{1, 3, 2, 4}))); // [-1,3,4]
        System.out.println(Arrays.toString(prob.nextGreaterElement(new int[]{4, 1, 3}, new int[]{4, 3, 2, 1}))); // [-1,-1,-1]
        System.out.println(Arrays.toString(prob.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4}))); // [3,-1]
    }
}
