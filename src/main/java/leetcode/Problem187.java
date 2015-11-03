package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 */
public class Problem187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i + 10 > s.length()) {
                break;
            }
            String str = s.substring(i, i + 10);
            if (set.contains(str)) {
                result.add(str);
            } else {
                set.add(str);
            }
        }
        return new ArrayList<>(result);
    }
}
