package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-uncommon-subsequence-ii/
 */
public class Problem522 {
    public int findLUSlength(String[] strs) {
        Set<String> ignored =  new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isSubsequence(strs[i], strs[j])) {
                    ignored.add(strs[i].length() <= strs[j].length() ? strs[i] : strs[j]);
                }
            }
        }
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            if (ignored.contains(strs[i])) {
                continue;
            }
            max = Math.max(max, strs[i].length());
        }
        return max;
    }

    private static boolean isSubsequence(String a, String b) {
        if (a.equals(b)) {
            return true;
        }
        String str1 = (a.length() <= b.length()) ? a : b;
        String str2 = (a.length() > b.length()) ? a : b;
        int i = 0;
        int j = 0;
        for (; i < str1.length(); i++) {
            while (j < str2.length()) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    j++;
                    break;
                }
                j++;
            }
            if (j == str2.length()) {
                break;
            }
        }
        if (i == str1.length() || (i == (str1.length() - 1) && str1.charAt(i) == str2.charAt(j - 1))) {
            return true;
        }
        return false;
    }
}
