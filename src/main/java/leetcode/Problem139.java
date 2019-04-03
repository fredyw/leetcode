package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/
 */
public class Problem139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, new HashSet<>());
    }

    private static boolean wordBreak(String s, List<String> dict, Set<String> memo) {
        for (String d : dict) {
            if (s.equals(d)) {
                return true;
            }
            if (memo.contains(s)) {
                return false;
            }
            if (s.startsWith(d)) {
                boolean found = wordBreak(s.substring(d.length()), dict, memo);
                if (found) {
                    return true;
                }
            }
        }
        memo.add(s);
        return false;
    }
}
