package leetcode;

/**
 * https://leetcode.com/problems/sum-of-two-integers/
 */
public class Problem371 {
    public int getSum(int a, int b) {
        int result = a ^ b;
        int carry = a & b;
        while (carry != 0) {
            int shiftedCarry = carry << 1;
            carry = result & shiftedCarry;
            result ^= shiftedCarry;
        }
        return result;
    }
}
