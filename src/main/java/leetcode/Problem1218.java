package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
 */
public class Problem1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int answer = 0;
        Map<Integer, Integer> dp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int val = dp.getOrDefault(arr[i] - difference, 0) + 1;
            answer = Math.max(answer, val);
            dp.put(arr[i], val);
        }
        return answer;
    }
}
