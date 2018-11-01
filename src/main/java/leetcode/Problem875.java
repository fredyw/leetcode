package leetcode;

/**
 * https://leetcode.com/problems/koko-eating-bananas/
 */
public class Problem875 {
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1;
        int hi = 1_000_000;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int time = time(piles, mid);
            if (time <= H) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static int time(int[] piles, int val) {
        int time = 0;
        for (int pile : piles) {
            int div = pile / val;
            int mod = pile % val;
            if (mod > 0) {
                div++;
            }
            time += div;
        }
        return time;
    }
}
