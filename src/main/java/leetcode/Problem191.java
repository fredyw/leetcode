package leetcode;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class Problem191 {
    public int hammingWeight(int n) {
        int result = 0;
        int x = n;
        for (int i = 0; i < 32; i++) {
            if ((x & 1) == 1) {
                result++;
            }
            x >>= 1;
        }
        return result;
    }
}
