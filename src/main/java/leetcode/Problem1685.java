package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
 */
public class Problem1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] answer = new int[nums.length];
        // TODO
        return answer;
    }

    public static void main(String[] args) {
        Problem1685 prob = new Problem1685();
        System.out.println(Arrays.toString(prob.getSumAbsoluteDifferences(new int[]{1,2,3}))); // [3,2,3]
        System.out.println(Arrays.toString(prob.getSumAbsoluteDifferences(new int[]{2,3,5}))); // [4,3,5]
        System.out.println(Arrays.toString(prob.getSumAbsoluteDifferences(new int[]{1,2,3,4,5}))); // [10,7,6,7,10]
        System.out.println(Arrays.toString(prob.getSumAbsoluteDifferences(new int[]{1,4,6,8,10}))); // [24,15,13,15,21]
    }
}
