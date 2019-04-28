package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/moving-stones-until-consecutive/
 */
public class Problem1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] array = new int[]{a, b, c};
        Arrays.sort(array);
        int min;
        if (array[1] - array[0] == 2 || array[2] - array[1] == 2) {
            min = 1;
        } else {
            min = ((array[1] - 1) - array[0] == 0 ? 0 : 1) + (array[2] - (array[1] + 1) == 0 ? 0 : 1);
        }
        int max = ((array[1] - 1) - array[0]) + (array[2] - (array[1] + 1));
        return new int[]{min, max};
    }
}
