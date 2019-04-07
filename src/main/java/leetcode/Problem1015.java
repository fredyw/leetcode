package leetcode;

/**
 * https://leetcode.com/problems/smallest-integer-divisible-by-k/
 */
public class Problem1015 {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        }
        int r = 1;
        for (int i = 1; i <= K; i++) {
            if (r % K == 0) {
                return i;
            }
            r = (r * 10 + 1) % K;
        }
        return -1;
    }
}
