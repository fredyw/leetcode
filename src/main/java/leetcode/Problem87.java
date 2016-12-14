package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/scramble-string/
 */
public class Problem87 {
    public boolean isScramble(String s1, String s2) {
        Set<String> set = scramble(s1, s2, new HashMap<>());
        return set.contains(s2);
    }

    private static Set<String> scramble(String str1, String str2, Map<String, Set<String>> memo) {
        if (memo.containsKey(str1)) {
            return memo.get(str1);
        }
        if (str1.isEmpty()) {
            return new HashSet<>();
        }
        if (str1.length() == 1) {
            Set<String> set = new HashSet<>();
            set.add(str1);
            return set;
        }
        Set<String> set = new HashSet<>();
        for (int i = 1; i < str1.length(); i++) {
            String sub1 = str1.substring(0, i);
            String sub2 = str1.substring(i);
            Set<String> set1 = scramble(sub1, str2, memo);
            Set<String> set2 = scramble(sub2, str2, memo);
            if (set1.size() > set2.size()) {
                for (String s1 : set1) {
                    for (String s2 : set2) {
                        if (str2.contains(s1 + s2)) {
                            set.add(s1 + s2);
                        }
                        if (str2.contains(s2 + s1)) {
                            set.add(s2 + s1);
                        }
                    }
                }
            } else {
                for (String s2 : set2) {
                    for (String s1 : set1) {
                        if (str2.contains(s1 + s2)) {
                            set.add(s1 + s2);
                        }
                        if (str2.contains(s2 + s1)) {
                            set.add(s2 + s1);
                        }
                    }
                }
            }
        }
        memo.put(str1, set);
        return set;
    }
}
