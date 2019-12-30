package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
 */
public class Problem1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int answer = 0;
        HashMap<String, Integer> memo = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            answer = Math.max(answer, longestSubsequence(arr, difference, 0, arr[i], 0, memo));
        }
        return answer;
    }

    private static int longestSubsequence(int[] arr, int difference, int index, int value,
                                          int length, Map<String, Integer> memo) {
        if (arr.length == index) {
            return length;
        }
        String key = index + "," + value + "," + length;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int max;
        if (arr[index] == value) {
            max = longestSubsequence(arr, difference, index + 1, arr[index] + difference,
                length + 1, memo);
        } else {
            max = longestSubsequence(arr, difference, index + 1, value, length, memo);
        }
        memo.put(key, max);
        return max;
    }

    public static void main(String[] args) {
        Problem1218 prob = new Problem1218();
        System.out.println(prob.longestSubsequence(new int[]{1, 2, 3, 4}, 1)); // 4
        System.out.println(prob.longestSubsequence(new int[]{1, 3, 5, 7}, 1)); // 1
        System.out.println(prob.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2)); // 4
        System.out.println(prob.longestSubsequence(new int[]{2, -6, -3, -6, 2, 0}, -2)); // 2
        System.out.println(prob.longestSubsequence(new int[]{3, 4, -3, -2, -4}, -5)); // 2
        System.out.println(prob.longestSubsequence(new int[]{3, 1, -2}, -5)); // 2
        System.out.println(prob.longestSubsequence(new int[]{1, 2}, 1)); // 2
    }
}
