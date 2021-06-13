package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/
 */
public class Problem1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Map<Integer, Boolean> coveredMap = new HashMap<>();
        for (int i = left; i <= right; i++) {
            coveredMap.put(i, false);
        }
        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                if (coveredMap.containsKey(i)) {
                    coveredMap.put(i, true);
                }
            }
        }
        boolean answer = true;
        for (boolean c : coveredMap.values()) {
            answer &= c;
        }
        return answer;
    }
}
