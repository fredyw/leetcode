package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/permutation-in-string/
 */
public class Problem567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = charCount(s1);
        for (int i = 0; i + s1.length() <= s2.length(); i++) {
            String sub = s2.substring(i, i + s1.length());
            Map<Character, Integer> map2 = charCount(sub);
            if (map1.equals(map2)) {
                return true;
            }
        }
        return false;
    }

    private static Map<Character, Integer> charCount(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Problem567 prob = new Problem567();
//        System.out.println(prob.checkInclusion("ab", "eidbaooo")); // true
//        System.out.println(prob.checkInclusion("ab", "eidboaoo")); // false
//        System.out.println(prob.checkInclusion("dinitrophenylhydrazine", "acetylphenylhydrazine")); // false
        System.out.println(prob.checkInclusion("adc", "dcda")); // true
    }
}
