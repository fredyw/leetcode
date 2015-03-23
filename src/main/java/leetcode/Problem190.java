package leetcode;

/**
 * https://leetcode.com/problems/reverse-bits/
 */
public class Problem190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int x = (n & 1);
            n >>= 1;
            result |= x << (31 - i);
        }
        return result;
    }
}
