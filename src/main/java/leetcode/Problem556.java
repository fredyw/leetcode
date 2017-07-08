package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-greater-element-iii/
 */
public class Problem556 {
    public int nextGreaterElement(int n) {
        boolean found = false;
        char[] c = Integer.toString(n).toCharArray();
        for (int i = c.length - 1; i > 0; i--) {
            if (c[i] > c[i - 1]) {
                found = true;
                int nextGreater = c.length - 1;
                for (int j = c.length - 1; j > 0; j--) {
                    if (c[i - 1] < c[j]) {
                        nextGreater = j;
                        break;
                    }
                }
                char tmp = c[nextGreater];
                c[nextGreater] = c[i - 1];
                c[i - 1] = tmp;
                Arrays.sort(c, i, c.length);
                break;
            }
        }
        if (!found) {
            return -1;
        }
        try {
            return Integer.parseInt(new String(c));
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
