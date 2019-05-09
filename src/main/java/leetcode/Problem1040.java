package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/moving-stones-until-consecutive-ii/
 */
public class Problem1040 {
    public int[] numMovesStonesII(int[] stones) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1040 prob = new Problem1040();
        System.out.println(Arrays.toString(prob.numMovesStonesII(new int[]{7, 4, 9}))); // [1,2]
        System.out.println(Arrays.toString(prob.numMovesStonesII(new int[]{6, 5, 4, 3, 10}))); // [2,3]
        System.out.println(Arrays.toString(prob.numMovesStonesII(new int[]{100, 101, 104, 102, 103}))); // [0,0]
        System.out.println(Arrays.toString(prob.numMovesStonesII(new int[]{1, 2, 5}))); // [2,2]
        System.out.println(Arrays.toString(prob.numMovesStonesII(new int[]{1, 3, 5, 7, 10}))); // [2,4]
    }
}
