package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/
 */
public class Problem1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            // count all the number of rows that are opposite of each other, e.g.
            // 1001
            // 1001
            // 0110 --> if we flip this, it will be 1001
            // total count = 3
            String original = "";
            String flipped = "";
            for (int j = 0; j < matrix[i].length; j++) {
                original += matrix[i][j];
                flipped += matrix[i][j] == 0 ? "1" : "0";
            }
            int count = 0;
            if (!map.containsKey(original) && !map.containsKey(flipped)) {
                count = 1;
                map.put(original, count);
            } else if (map.containsKey(original)) {
                count = map.get(original) + 1;
                map.put(original, count);
            } else {
                count = map.get(flipped) + 1;
                map.put(flipped, count);
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }
}
