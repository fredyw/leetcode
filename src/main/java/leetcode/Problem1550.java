package leetcode;

/**
 * https://leetcode.com/problems/three-consecutive-odds/
 */
public class Problem1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                count++;
            } else {
                if (count >= 3) {
                    return true;
                }
                count = 0;
            }
        }
        return count >= 3;
    }
}
