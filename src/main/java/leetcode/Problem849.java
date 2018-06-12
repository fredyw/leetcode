package leetcode;

/**
 * https://leetcode.com/problems/maximize-distance-to-closest-person/
 */
public class Problem849 {
    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int prevIdx = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (prevIdx == -1) {
                   max = Math.max(max, i);
                } else {
                    max = Math.max(max, (i - prevIdx) / 2);
                }
                prevIdx = i;
            }
        }
        if (prevIdx != -1) {
            max = Math.max(max, seats.length - prevIdx - 1);
        }
        return max;
    }
}
