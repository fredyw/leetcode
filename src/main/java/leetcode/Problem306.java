package leetcode;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/additive-number/
 */
public class Problem306 {
    public boolean isAdditiveNumber(String num) {
        for (int i = 0; i < num.length(); i++) {
            boolean result = isAdditiveNumber(num, i + 1);
            if (result) {
                return true;
            }
        }
        return false;
    }

    private boolean isAdditiveNumber(String num, int idx) {
        BigInteger a = new BigInteger(num.substring(0, idx));
        int beg = idx;
        for (int i = 1; i < num.length(); i++) {
            int endIdx = idx + i;
            if (endIdx <= num.length()) {
                String str = num.substring(beg, endIdx);
                if (str.length() > 1 && str.startsWith("0")) {
                    return false;
                }
                BigInteger b = new BigInteger(str);
                boolean result = isAdditiveNumber(num, a, b, endIdx);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAdditiveNumber(String num, BigInteger a, BigInteger b, int idx) {
        BigInteger x = a;
        BigInteger y = b;
        BigInteger sum = x.add(y);
        String sumStr = sum.toString();
        int begIdx = idx;
        int endIdx = begIdx + sumStr.length();
        if (endIdx > num.length()) {
            return false;
        }
        String nextStr = num.substring(begIdx, endIdx);
        if (!sumStr.equals(nextStr)) {
            return false;
        }
        while (endIdx < num.length()) {
            x = y;
            y = sum;
            sum = x.add(y);
            sumStr = sum.toString();
            begIdx = endIdx;
            endIdx = begIdx + sumStr.length();
            if (endIdx > num.length()) {
                return false;
            }
            nextStr = num.substring(begIdx, endIdx);
            if (!sumStr.equals(nextStr)) {
                return false;
            }
        }
        return true;
    }
}
