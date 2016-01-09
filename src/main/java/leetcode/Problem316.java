package leetcode;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 */
public class Problem316 {
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        TreeMap<Character, TreeSet<Integer>> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(i);
                map.put(c, set);
            } else {
                map.get(c).add(i);
            }
        }
        Set<Character> chars = map.keySet();
        while (!map.isEmpty()) {
            char resultChar = ' ';
            int resultIdx = -1;
            for (char c1 : chars) {
                TreeSet<Integer> set1 = map.get(c1);
                int idx = set1.first();
                boolean skipped = false;
                for (char c2 : chars) {
                    if (c1 == c2) {
                        continue;
                    }
                    TreeSet<Integer> set2 = map.get(c2);
                    int hiIdx = set2.last();
                    if (idx > hiIdx) {
                        skipped = true;
                        break;
                    }
                }
                if (!skipped) {
                    resultChar = c1;
                    resultIdx = idx;
                    break;
                }
            }
            if (resultIdx != -1) {
                int idx = resultIdx;
                sb.append(resultChar);
                map.remove(resultChar);
                for (char c3 : chars) {
                    TreeSet<Integer> set3 = map.get(c3);
                    set3.removeIf((e) -> e < idx);
                }
            }
        }
        return sb.toString();
    }
}
