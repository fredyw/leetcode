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
        Set<String> set = scramble(s1, new HashMap<>());
        return set.contains(s2);
    }

    private static Set<String> scramble(String str, Map<String, Set<String>> memo) {
        if (memo.containsKey(str)) {
            return memo.get(str);
        }
        if (str.isEmpty()) {
            return new HashSet<>();
        }
        if (str.length() == 1) {
            Set<String> set = new HashSet<>();
            set.add(str);
            return set;
        }
        Set<String> set = new HashSet<>();
        for (int i = 1; i < str.length(); i++) {
            String sub1 = str.substring(0, i);
            String sub2 = str.substring(i);
            Set<String> set1 = scramble(sub1, memo);
            Set<String> set2 = scramble(sub2, memo);
            for (String s1 : set1) {
                for (String s2 : set2) {
                    set.add(s1 + s2);
                }
            }
            for (String s2 : set2) {
                for (String s1 : set1) {
                    set.add(s2 + s1);
                }
            }
        }
        memo.put(str, set);
        return set;
    }

    public static void main(String[] args) {
        Problem87 prob = new Problem87();
        System.out.println(prob.isScramble("great", "rgeat")); // true
        System.out.println(prob.isScramble("great", "rgtae")); // true
        System.out.println(prob.isScramble("abcd", "bdac")); // false
        System.out.println(prob.isScramble("abcd", "acdb")); // true
        System.out.println(prob.isScramble("abcdefghij", "efghijcadb")); // false
    }
}
