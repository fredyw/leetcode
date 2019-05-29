package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/height-checker/
 */
public class Problem1051 {
    public int heightChecker(int[] heights) {
        int[] unsorted = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        int answer = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != unsorted[i]) {
                answer++;
            }
        }
        return answer;
    }
}
