package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
public class Problem1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1365 prob = new Problem1365();
        System.out.println(Arrays.toString(prob.smallerNumbersThanCurrent(new int[]{8,1,2,2,3}))); // [4,0,1,1,3]
        System.out.println(Arrays.toString(prob.smallerNumbersThanCurrent(new int[]{6,5,4,8}))); // [2,1,0,3]
        System.out.println(Arrays.toString(prob.smallerNumbersThanCurrent(new int[]{7,7,7,7}))); // [0,0,0,0]
    }
}
