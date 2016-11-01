package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 */
public class Problem424 {
    public int characterReplacement(String s, int k) {
        int max = 0;
        Map<Character, Set<Integer>> charIdxMap = charIdxMap(s);
        for (Map.Entry<Character, Set<Integer>> entry : charIdxMap.entrySet()) {
            char c = entry.getKey();
            Set<Integer> indices = entry.getValue();
            for (int idx : indices) {
                int tmpMax = 0;
                int i = idx;
                for (int j = 0; i < s.length() && j < k; i++) {
                    if (!indices.contains(i)) {
                        j++;
                    }
                    tmpMax++;
                }
                while (i < s.length() && s.charAt(i++) == c) {
                    tmpMax++;
                }
                max = Math.max(max, tmpMax);
            }
        }
        return max;
    }

    private static Map<Character, Set<Integer>> charIdxMap(String s) {
        Map<Character, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new HashSet<>());
            }
            map.get(c).add(i);
        }
        return map;
    }

    public static void main(String[] args) {
        Problem424 prob = new Problem424();
//        System.out.println(prob.characterReplacement("ABAB", 2)); // 4
//        System.out.println(prob.characterReplacement("AABABBA", 1)); // 4
//        System.out.println(prob.characterReplacement("AABAABBA", 1)); // 5
//        System.out.println(prob.characterReplacement("ACABD", 2)); // 4
        System.out.println(prob.characterReplacement("ABBB", 2)); // 4
        System.out.println(prob.characterReplacement("ABBBBABABBC", 2)); // 9
    }
}
