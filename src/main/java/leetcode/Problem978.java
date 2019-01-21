package leetcode;

/**
 * https://leetcode.com/problems/longest-turbulent-subarray/
 */
public class Problem978 {
    public int maxTurbulenceSize(int[] A) {
        int max = 0;
        int tmpMax = 1;
        Direction direction = Direction.NONE;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                if (direction == Direction.UP) {
                    tmpMax++;
                } else {
                    tmpMax = 2;
                }
                direction = Direction.DOWN;
            } else if (A[i] > A[i + 1]) {
                if (direction == Direction.DOWN) {
                    tmpMax++;
                } else {
                    tmpMax = 2;
                }
                direction = Direction.UP;
            } else {
                direction = Direction.NONE;
            }
            max = Math.max(max, tmpMax);
        }
        max = Math.max(max, tmpMax);
        return max;
    }

    private enum Direction {
        UP, DOWN, NONE
    }
}
