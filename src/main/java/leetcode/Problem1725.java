package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/
 */
public class Problem1725 {
    public int countGoodRectangles(int[][] rectangles) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int[] rectangle : rectangles) {
            int val = Math.max(answer, Math.min(rectangle[0], rectangle[1]));
            map.put(val, map.getOrDefault(val, 0) + 1);
            max = Math.max(max, val);
        }
        return map.get(max);
    }
}
