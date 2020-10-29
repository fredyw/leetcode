package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
 */
public class Problem1593 {
    public int maxUniqueSplit(String s) {
        return maxUniqueSplit(s, 0, new HashSet<>());
    }

    private static int maxUniqueSplit(String s, int i, Set<String> set) {
        int max = set.size();
        for (int j = i; j < s.length(); j++) {
            String sub = s.substring(i, j + 1);
            if (!set.contains(sub)) {
                set.add(sub);
                max = Math.max(max, maxUniqueSplit(s, j + 1, set));
                set.remove(sub);
            }
        }
        return max;
    }
}
