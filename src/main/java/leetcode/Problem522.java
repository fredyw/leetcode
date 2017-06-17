package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-uncommon-subsequence-ii/
 */
public class Problem522 {
    public int findLUSlength(String[] strs) {
        int max = -1;
//        Set<String> set = new HashSet<>();
        Set<String> ignored =  new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            if (ignored.contains(strs[i])) {
                continue;
            }
            for (int j = i + 1; j < strs.length; j++) {
                if (ignored.contains(strs[j])) {
                    continue;
                }
                if (strs[i].equals(strs[j])) {
                    ignored.add(strs[i]);
                } else if (strs[i].contains(strs[j])) {
                    ignored.add(strs[i]);
                } else if (strs[j].contains(strs[i])) {
                    ignored.add(strs[j]);
                } else {
//                    set.add(strs[j]);
                    max = Math.max(max, strs[j].length());
                }
            }
        }
//        int max = 0;
//        for (int i = 0; i < set.size(); i++) {
//            max = Math.max(max, set.get(i).length());
//            for (int j = i + 1; j < set.size(); j++) {
//                max = Math.max(max, set.get(j).length());
//            }
//        }
//        return max;
        return max;
    }

    public static void main(String[] args) {
        Problem522 prob = new Problem522();
//        System.out.println(prob.findLUSlength(new String[]{"aba", "cdc", "eae"})); // 3
//        System.out.println(prob.findLUSlength(new String[]{"aba", "eae"})); // 3
//        System.out.println(prob.findLUSlength(new String[]{"xbc", "acd"})); // 3
        System.out.println(prob.findLUSlength(new String[]{"abc", "x"})); // 3
//        System.out.println(prob.findLUSlength(new String[]{"aabbcc", "aabbcc", "cb", "abc"})); // 2
//        System.out.println(prob.findLUSlength(new String[]{"aabbcc", "aabbcc", "abc"})); // -1
//        System.out.println(prob.findLUSlength(new String[]{"abc", "abc", "xyzdef", "xyzd"})); // 6
//        System.out.println(prob.findLUSlength(new String[]{"aaa", "aaa", "aa"})); // -1
//        System.out.println(prob.findLUSlength(new String[]{"aabbcc", "aabbcc", "cb"})); // 2
    }
}
