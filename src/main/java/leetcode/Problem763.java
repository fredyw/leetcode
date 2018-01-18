package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/partition-labels/
 */
public class Problem763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int[] last = new int[26];
        for (int i = 0; i < last.length; i++) {
            last[i] = -1;
        }
        for (int i = S.length() - 1; i >= 0; i--) {
            if (last[S.charAt(i) - 'a'] == -1) {
                last[S.charAt(i) - 'a'] = i;
            }
        }
        int part = -1;
        int from = 0;
        int to = 0;
        while (from < S.length()) {
            char c = S.charAt(from);
            if (to < last[c - 'a']) {
                to = last[c - 'a'];
            }
            if (from == to) {
                result.add(to - part);
                part = from;
            }
            from++;
        }
        return result;
    }
}
