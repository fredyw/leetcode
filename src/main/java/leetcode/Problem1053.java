package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/previous-permutation-with-one-swap/
 */
public class Problem1053 {
    public int[] prevPermOpt1(int[] A) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1053 prob = new Problem1053();
        System.out.println(Arrays.toString(prob.prevPermOpt1(new int[]{3, 2, 1}))); // [3,1,2]
        System.out.println(Arrays.toString(prob.prevPermOpt1(new int[]{1, 1, 5}))); // [1,1,5]
        System.out.println(Arrays.toString(prob.prevPermOpt1(new int[]{1, 9, 4, 6, 7}))); // [1,7,4,6,9]
        System.out.println(Arrays.toString(prob.prevPermOpt1(new int[]{3, 1, 1, 3}))); // [1,3,1,3]
    }
}
