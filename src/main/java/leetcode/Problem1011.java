package leetcode;

/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class Problem1011 {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0;
        int right = 0;
        for (int w : weights) {
            left = Math.max(left, w); // max
            right += w; // sum
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (isPossible(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isPossible(int[] weights, int d, int max) {
        int sum = 0;
        int split = 1;
        for (int weight : weights) {
            if (sum + weight > max) {
                sum = 0;
                split++;
                if (split > d) {
                    return false;
                }
            }
            sum += weight;
        }
        return true;
    }
}
