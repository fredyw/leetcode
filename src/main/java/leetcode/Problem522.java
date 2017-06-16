package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-uncommon-subsequence-ii/
 */
public class Problem522 {
    public int findLUSlength(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (!map.containsKey(strs[i])) {
                map.put(strs[i], 1);
            } else {
                map.put(strs[i], map.get(strs[i]) + 1);
            }
        }
        List<String> list = new ArrayList<>();
        for (String str : strs) {
            int count = map.get(str);
            if (count == 1) {
                list.add(str);
            }
        }
        int max = -1;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                max = Math.max(max, Math.max(list.get(i).length(), list.get(j).length()));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem522 prob = new Problem522();
//        System.out.println(prob.findLUSlength(new String[]{"aba", "cdc", "eae"})); // 3
//        System.out.println(prob.findLUSlength(new String[]{"aba", "eae"})); // 3
//        System.out.println(prob.findLUSlength(new String[]{"xbc", "acd"})); // 3
//        System.out.println(prob.findLUSlength(new String[]{"abc", "x"})); // 3
//        System.out.println(prob.findLUSlength(new String[]{"aabbcc", "aabbcc", "cb", "abc"})); // 2
//        System.out.println(prob.findLUSlength(new String[]{"abc", "abc", "xyzdef", "xyzd"})); // 6
//        System.out.println(prob.findLUSlength(new String[]{"aaa", "aaa", "aa"})); // -1
        System.out.println(prob.findLUSlength(new String[]{"aabbcc", "aabbcc", "cb"})); // 2
    }
}
