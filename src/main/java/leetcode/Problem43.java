package leetcode;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/multiply-strings/
 */
public class Problem43 {
    public String multiply(String num1, String num2) {
        BigInteger result = new BigInteger(num1).multiply(new BigInteger(num2));
        return result.toString();
    }
}
