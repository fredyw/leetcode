package leetcode;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class Problem287 {
    public int findDuplicate(int[] nums) {
        BigInteger lookup = new BigInteger("0");
        for (int num : nums) {
            BigInteger n = lookup.shiftRight(num).and(new BigInteger("1"));
            if (n.equals(new BigInteger("1"))) {
                return num;
            }
            BigInteger m = new BigInteger("1").shiftLeft(num);
            lookup = lookup.or(m);
        }
        throw new RuntimeException("Should not happen");
    }
}
