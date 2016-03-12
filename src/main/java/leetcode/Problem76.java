package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class Problem76 {
    public String minWindow(String s, String t) {
//        Map<Character, Integer> needed = new HashMap<>();
        int size = 128;
        int[] needed = new int[size];
        for (char c : t.toCharArray()) {
//            needed.put(c, needed.getOrDefault(c, 1) + 1);
            needed[c] += 1;
        }
//        Map<Character, Integer> found = new HashMap<>();
        int[] found = new int[size];
        int count = 0;
        int minWindow = Integer.MAX_VALUE;
        int beginIdx = 0;
        int endIdx = 0;
        int begin = 0;
        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            if (!needed.containsKey(endChar)) {
                continue;
            }
            found.put(endChar, found.getOrDefault(endChar, 1) + 1);
            if (found.get(endChar) <= needed.get(endChar)) {
                count++;
            }
            if (count == t.length()) {
                char begChar = s.charAt(begin);
                while (!found.containsKey(begChar) || needed.get(begChar) < found.get(begChar)) {
                    if (!found.containsKey(begChar)) {
                        begChar = s.charAt(begin);
                        begin++;
                    } else {
                        if (needed.get(begChar) < found.get(begChar)) {
                            found.put(begChar, found.get(begChar) - 1);
                            begChar = s.charAt(begin);
                            begin++;
                        }
                    }
                }
                int window = end - begin + 1;
                if (window < minWindow) {
                    beginIdx = begin;
                    endIdx = end;
                    minWindow = window;
                }
            }
        }
        if (beginIdx == endIdx) {
            return "";
        }
        return s.substring(beginIdx - 1, endIdx + 1);
    }

    public static void main(String[] args) {
        Problem76 prob = new Problem76();
        System.out.println(prob.minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(prob.minWindow("ADOBECODEBANC", "ABCX")); //
    }
}
