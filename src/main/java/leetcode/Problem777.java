package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/swap-adjacent-in-lr-string/
 */
public class Problem777 {
    public boolean canTransform(String start, String end) {
        char[] s = start.toCharArray();
        char[] e = end.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] != e[i]) {
                if (e[i] == 'L') {
                    int j = i;
                    while (j < s.length && s[j] == 'X') {
                        j++;
                    }
                    if (j == s.length || s[j] != 'L') {
                        return false;
                    }
                    swap(s, i, j);
                }
            }
        }
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] != e[i]) {
                if (e[i] == 'R') {
                    int j = i;
                    while (j >= 0 && s[j] == 'X') {
                        j--;
                    }
                    if (j < 0 || s[j] != 'R') {
                        return false;
                    }
                    swap(s, i, j);
                }
            }
        }
        return Arrays.equals(s, e);
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
