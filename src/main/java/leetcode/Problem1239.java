package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 */
public class Problem1239 {
    public int maxLength(List<String> arr) {
        int answer = 0;
        Map<String, Integer> memo = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            answer = Math.max(answer, maxLength(arr, i, "", memo));
        }
        return answer;
    }

    private static int maxLength(List<String> arr, int index, String accu, Map<String, Integer> memo) {
        if (arr.size() == index) {
            return accu.length();
        }
        String key = index + "," + accu;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int max = 0;
        for (int i = index; i < arr.size(); i++) {
            String s = arr.get(i);
            if (isUnique(accu + s)) {
                max = Math.max(max, maxLength(arr, i + 1, accu + s, memo));
            } else {
                max = Math.max(max, maxLength(arr, i + 1, accu, memo));
            }
        }
        memo.put(key, max);
        return max;
    }

    private static boolean isUnique(String s) {
        boolean[] count = new boolean[26];
        for (char c : s.toCharArray()) {
            if (count[c - 'a']) {
                return false;
            }
            count[c - 'a'] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem1239 prob = new Problem1239();
        System.out.println(prob.maxLength(Arrays.asList("un", "iq", "ue"))); // 4
        System.out.println(prob.maxLength(Arrays.asList("cha", "r", "act", "ers"))); // 6
        System.out.println(prob.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz"))); // 26
    }
}
