package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class Problem953 {
    public boolean isAlienSorted(String[] words, String order) {
        String[] sorted = Arrays.copyOf(words, words.length);
        int[] o = order(order);
        Arrays.sort(sorted, (a, b) -> {
            int min = Math.min(a.length(), b.length());
            for (int i = 0; i < min; i++) {
                int diff = o[a.charAt(i) - 'a'] - o[b.charAt(i) - 'a'];
                if (diff != 0) {
                    return diff;
                }
            }
            if (a.length() < b.length()) {
                return -1;
            } else if (a.length() > b.length()) {
                return 1;
            }
            return 0;
        });
        return Arrays.equals(words, sorted);
    }

    private static int[] order(String s) {
        int[] order = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            order[s.charAt(i) - 'a'] = i;
        }
        return order;
    }
}
