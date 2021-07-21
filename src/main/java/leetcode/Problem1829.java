package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-xor-for-each-query/
 */
public class Problem1829 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1829 prob = new Problem1829();
        System.out.println(Arrays.toString(prob.getMaximumXor(new int[]{0,1,1,3}, 2))); // [0,3,2,3]
        System.out.println(Arrays.toString(prob.getMaximumXor(new int[]{2,3,4,7}, 3))); // [5,2,6,5]
        System.out.println(Arrays.toString(prob.getMaximumXor(new int[]{0,1,2,2,5,7}, 3))); // [4,3,6,4,6,7]
    }
}
