package leetcode;

/**
 * https://leetcode.com/problems/longest-mountain-in-array/
 */
public class Problem845 {
    public int longestMountain(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int result = 0;
        int left = -1;
        int current = 0;
        int prev = A[0];
        boolean up = false;
        boolean down = false;
        while (current < A.length) {
            if (prev < A[current]) {
                if (left == -1 || down) {
                    left = current - 1;
                }
                prev = Math.max(prev, A[current]);
                up = true;
                down = false;
            } else if (up && prev > A[current]) {
                prev = Math.min(prev, A[current]);
                result = Math.max(result, current - left + 1);
                down = true;
            } else {
                left = -1;
                prev = A[current];
                up = false;
                down = false;
            }
            current++;
        }
        return result;
    }
}
