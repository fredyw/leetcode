package leetcode;

/**
 * https://leetcode.com/problems/single-number/
 */
public class Problem136 {
    public int singleNumber(int[] A) {
        int result = 0;
        for (int a : A) {
            result ^= a;
        }
        return result;
    }
}
