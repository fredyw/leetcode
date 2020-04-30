package leetcode;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
 */
public class Problem1404 {
    public int numSteps(String s) {
        int answer = 0;
        BigInteger n = new BigInteger(s, 2);
        while (!n.equals(BigInteger.ONE)) {
            if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                n = n.divide(BigInteger.valueOf(2));
            } else {
                n = n.add(BigInteger.ONE);
            }
            answer++;
        }
        return answer;
    }
}
