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
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; j < stones.length; ++j) {
            while (stones[j] - stones[i] >= stones.length) {
                i++;
            }
            // corner case
            if (j - i + 1 == stones.length - 1 && stones[j] - stones[i] == stones.length - 2) {
                min = Math.min(min, 2);
            } else {
                min = Math.min(min, stones.length - (j - i + 1));
            }
        }
        return new int[]{min, max};
    }
}
