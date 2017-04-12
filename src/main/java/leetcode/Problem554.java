package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/brick-wall/
 */
public class Problem554 {
    public int leastBricks(List<List<Integer>> wall) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int totalLength = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                totalLength += row.get(i);
                if (!map.containsKey(totalLength)) {
                    int count = 1;
                    max = Math.max(max, count);
                    map.put(totalLength, count);
                } else {
                    int count = map.get(totalLength) + 1;
                    max = Math.max(max, count);
                    map.put(totalLength, count);
                }
            }
        }
        return wall.size() - max;
    }
}
