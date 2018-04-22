package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/shortest-distance-to-a-character/
 */
public class Problem821 {
    public int[] shortestToChar(String S, char C) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                indexes.add(i);
            }
        }
        int[] result = new int[S.length()];
        int idx = 0;
        for (int i = 0; i < S.length(); i++) {
            if (i > indexes.get(idx)) {
                idx++;
                if (idx == indexes.size()) {
                    idx--;
                }
            }
            if (idx - 1 >= 0) {
                result[i] = Math.min(Math.abs(indexes.get(idx - 1) - i),
                    Math.abs(indexes.get(idx) - i));
            } else {
                result[i] = Math.abs(indexes.get(idx) - i);
            }
        }
        return result;
    }
}
