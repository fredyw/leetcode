package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/assign-cookies/
 */
public class Problem455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int result = 0;
        int size = 0;
        for (int greed = 0; greed < g.length; greed++) {
            for (; size < s.length; size++) {
                if (s[size] >= g[greed]) {
                    result++;
                    size++;
                    break;
                }
            }
        }
        return result;
    }
}
