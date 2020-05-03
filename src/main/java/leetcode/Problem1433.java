package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/check-if-a-string-can-break-another-string/
 */
public class Problem1433 {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        char[] c2 = s2.toCharArray();
        Arrays.sort(c2);
        boolean b1 = true;
        boolean b2 = true;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] > c2[i]) {
                b1 = false;
            }
            if (c2[i] > c1[i]) {
                b2 = false;
            }
        }
        return b1 | b2;
    }
}
