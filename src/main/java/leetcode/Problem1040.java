package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/moving-stones-until-consecutive-ii/
 */
public class Problem1040 {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int max = Math.max(stones[1] - stones[0], stones[stones.length - 1] - stones[stones.length - 2]) - 1;
        for (int i = 1; i < stones.length - 2; i++) {
            max += stones[i + 1] - stones[i] - 1;
        }
        if (max == 0) {
            return new int[]{0, max};
        }
        int min = 0;
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        Problem1040 prob = new Problem1040();
        System.out.println(Arrays.toString(prob.numMovesStonesII(new int[]{7, 4, 9}))); // [1,2]
        System.out.println(Arrays.toString(prob.numMovesStonesII(new int[]{6, 5, 4, 3, 10}))); // [2,3]
        System.out.println(Arrays.toString(prob.numMovesStonesII(new int[]{100, 101, 104, 102, 103}))); // [0,0]
        System.out.println(Arrays.toString(prob.numMovesStonesII(new int[]{1, 2, 5}))); // [2,2]
        System.out.println(Arrays.toString(prob.numMovesStonesII(new int[]{1, 3, 5, 7, 10}))); // [2,4]
        System.out.println(Arrays.toString(prob.numMovesStonesII(new int[]{1, 5, 8, 12}))); // [2,5]
        System.out.println(Arrays.toString(prob.numMovesStonesII(new int[]{1, 5, 8, 13}))); // [2,6]
        System.out.println(Arrays.toString(prob.numMovesStonesII(new int[]{1, 5, 8, 13, 18}))); // [3,10]
        System.out.println(Arrays.toString(prob.numMovesStonesII(new int[]{1, 5, 8, 13, 14}))); // [3,9]
        System.out.println(Arrays.toString(prob.numMovesStonesII(new int[]{1, 5, 8, 13, 18, 23}))); // [4,14]
        System.out.println(Arrays.toString(prob.numMovesStonesII(new int[]{1, 5, 8, 13, 18, 23, 24}))); // [4,17]
        System.out.println(Arrays.toString(prob.numMovesStonesII(new int[]{1, 5, 8, 13, 19, 23, 24}))); // [4,17]
        System.out.println(Arrays.toString(prob.numMovesStonesII(new int[]{1, 50, 100, 200}))); // [3,148]
        System.out.println(Arrays.toString(prob.numMovesStonesII(new int[]{4, 8, 10, 12, 14, 20}))); // [3,8]
    }
}
