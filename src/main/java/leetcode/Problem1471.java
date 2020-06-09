package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/the-k-strongest-values-in-an-array/
 */
public class Problem1471 {
    public int[] getStrongest(int[] arr, int k) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1471 prob = new Problem1471();
        System.out.println(Arrays.toString(prob.getStrongest(new int[]{1,2,3,4,5}, 2))); // [5,1]
        System.out.println(Arrays.toString(prob.getStrongest(new int[]{1,1,3,5,5}, 2))); // [5,5]
        System.out.println(Arrays.toString(prob.getStrongest(new int[]{6,7,11,7,6,8}, 5))); // [11,8,6,6,7]
        System.out.println(Arrays.toString(prob.getStrongest(new int[]{6,-3,7,2,11}, 3))); // [-3,11,2]
        System.out.println(Arrays.toString(prob.getStrongest(new int[]{-7,22,17,3}, 2))); // [22,17]
    }
}
