package leetcode;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 */
public class Problem374 {
    // test case
    private static int guess(int num) {
        if (num == 1702766719) {
            return 0;
        } else if (num < 1702766719) {
            return 1;
        }
        return -1;
    }

    public int guessNumber(int n) {
        long lo = 1;
        long hi = n;
        while (lo <= hi) {
            long lmid = (lo + hi) / 2;
            int mid = (int) lmid;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) < 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        throw new RuntimeException("Number not found");
    }
}
