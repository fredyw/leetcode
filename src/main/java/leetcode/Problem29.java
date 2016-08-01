package leetcode;

/**
 * https://oj.leetcode.com/problems/divide-two-integers/
 */
public class Problem29 {
    public int divide(int dividend, int divisor) {
        long result = 0;
        long longDividend = dividend;
        long longDivisor = divisor;
        boolean negative = false;
        if ((longDividend < 0 && longDivisor > 0)) {
            negative = true;
            longDividend = ~longDividend + 1;
        } else if (longDividend > 0 && longDivisor < 0) {
            negative = true;
            longDivisor = ~longDivisor + 1;
        } else if (longDividend < 0 && longDivisor < 0) {
            longDividend = ~longDividend + 1;
            longDivisor = ~longDivisor + 1;
        }
        long tmpDividend = longDividend;
        while (tmpDividend > longDivisor) {
            long tmpDivisor = longDivisor;
            long tmpResult = 1;
            while (tmpDividend > tmpDivisor) {
                tmpDivisor = tmpDivisor << 1;
                tmpResult <<= 1;
            }
            tmpResult >>= 1;
            result += tmpResult;
            tmpDivisor = tmpDivisor >> 1;
            tmpDividend -= tmpDivisor;
        }
        if (tmpDividend == longDivisor) {
            result += 1;
        }

        result = (negative) ? ~result + 1 : result;
        if (result >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }
}
