package leetcode;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-different-integers-in-a-string/
 */
public class Problem1805 {
    public int numDifferentIntegers(String word) {
        String[] digits = word.replaceAll("[a-z]+", " ").split(" ");
        Set<BigInteger> set = new HashSet<>();
        for (String digit : digits) {
            if (digit.isEmpty()) {
                continue;
            }
            set.add(new BigInteger(digit));
        }
        return set.size();
    }
}
