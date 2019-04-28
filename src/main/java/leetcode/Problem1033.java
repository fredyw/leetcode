package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/moving-stones-until-consecutive/
 */
public class Problem1033 {
    public int[] numMovesStones(int a, int b, int c) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1033 prob = new Problem1033();
        System.out.println(Arrays.toString(prob.numMovesStones(1, 2, 5))); // [1, 2]
        System.out.println(Arrays.toString(prob.numMovesStones(1, 2, 3))); // [0, 0]
        System.out.println(Arrays.toString(prob.numMovesStones(1, 3, 5))); // [1, 2]
        System.out.println(Arrays.toString(prob.numMovesStones(4, 3, 2))); // [0, 0]
        System.out.println(Arrays.toString(prob.numMovesStones(1, 5, 9))); // [2, 6]
    }
}
