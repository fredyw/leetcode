package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/
 */
public class Problem1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            String original = "";
            String flipped = "";
            for (int j = 0; j < matrix[i].length; j++) {
                original += matrix[i][j];
                flipped += matrix[i][j] == 0 ? "1" : "0";
            }
            if (!map.containsKey(original) && !map.containsKey(flipped)) {
                map.put(original, 1);
            } else if (map.containsKey(original)) {
                map.put(original, map.get(original) + 1);
            } else {
                map.put(flipped, map.get(flipped) + 1);
            }
        }
        int answer = 0;
        for (int count : map.values()) {
            answer = Math.max(answer, count);
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1072 prob = new Problem1072();
        System.out.println(prob.maxEqualRowsAfterFlips(new int[][]{
            {0, 1},
            {1, 1}
        })); // 1
        System.out.println(prob.maxEqualRowsAfterFlips(new int[][]{
            {0, 1},
            {1, 0}
        })); // 2
        System.out.println(prob.maxEqualRowsAfterFlips(new int[][]{
            {0, 0, 0},
            {0, 0, 1},
            {1, 1, 0}
        })); // 2
        System.out.println(prob.maxEqualRowsAfterFlips(new int[][]{
            {0, 0, 0},
            {0, 0, 1},
            {1, 0, 1},
            {1, 1, 0}
        })); // 2
    }
}
