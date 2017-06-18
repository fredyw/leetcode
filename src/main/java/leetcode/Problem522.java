package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-uncommon-subsequence-ii/
 */
public class Problem522 {
    public int findLUSlength(String[] strs) {
        int max = -1;
        Set<String> ignored =  new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isSubsequence(strs[i], strs[j])) {
                    ignored.add(strs[i].length() <= strs[j].length() ? strs[i] : strs[j]);
                } else {
                    if (!ignored.contains(strs[i])) {
                        max = Math.max(max, strs[i].length());
                    }
                    if (!ignored.contains(strs[j])) {
                        max = Math.max(max, strs[j].length());
                    }
                }
            }
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
        if (i == str1.length() || str1.charAt(i) == str2.charAt(j - 1)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Problem522 prob = new Problem522();
//        System.out.println(isSubsequence("abcde", "xyz"));
//        System.out.println(isSubsequence("aaabbbccc", "abc"));
//        System.out.println(isSubsequence("aaabbbccc", "aabcc"));
//        System.out.println(isSubsequence("aaabbbccc", "aabccd"));
//        System.out.println(isSubsequence("abc", "xyz"));
//        System.out.println(isSubsequence("aaa", "acb"));
//        System.out.println(isSubsequence("aabbcc", "bcc"));
        System.out.println(prob.findLUSlength(new String[]{"aba", "cdc", "eae"})); // 3
        System.out.println(prob.findLUSlength(new String[]{"aba", "eae"})); // 3
        System.out.println(prob.findLUSlength(new String[]{"xbc", "acd"})); // 3
        System.out.println(prob.findLUSlength(new String[]{"abc", "x"})); // 3
        System.out.println(prob.findLUSlength(new String[]{"aabbcc", "aabbcc", "cb", "abc"})); // 2
        System.out.println(prob.findLUSlength(new String[]{"aabbcc", "aabbcc", "abc"})); // -1
        System.out.println(prob.findLUSlength(new String[]{"abc", "abc", "xyzdef", "xyzd"})); // 6
        System.out.println(prob.findLUSlength(new String[]{"aaa", "aaa", "aa"})); // -1
        System.out.println(prob.findLUSlength(new String[]{"aabbcc", "aabbcc", "cb"})); // 2
        System.out.println(prob.findLUSlength(new String[]{"aaa", "acb"})); // 3
        System.out.println(prob.findLUSlength(new String[]{"aabbcc", "aabbcc", "bc", "bcc"})); // -1
        System.out.println(prob.findLUSlength(new String[]{"aabbcc", "aabbcc","bc","bcc","aabbccc"})); // 7
    }
}
