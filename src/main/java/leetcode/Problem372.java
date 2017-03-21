package leetcode;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/super-pow/
 */
public class Problem372 {
    public int superPow(int a, int[] b) {
        // https://en.wikipedia.org/wiki/Modular_exponentiation#Memory-efficient_method
        BigInteger bia = new BigInteger("" + a);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            sb.append(b[i]);
        }
        BigInteger bib = new BigInteger(sb.toString());
        return bia.modPow(bib, new BigInteger("" + 1337)).intValue();
    }
}
