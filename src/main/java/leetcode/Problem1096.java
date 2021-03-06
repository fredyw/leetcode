package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/brace-expansion-ii/
 */
public class Problem1096 {
    public List<String> braceExpansionII(String expression) {
        List<List<List<String>>> groups = new ArrayList<>();
        groups.add(new ArrayList<>());
        int level = 0;
        int start = -1;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '{') {
                if (level == 0) {
                    start = i + 1;
                }
                level++;
            } else if (c == '}') {
                level--;
                if (level == 0) {
                    groups.get(groups.size() - 1).add(
                        braceExpansionII(expression.substring(start, i)));
                }
            } else if (c == ',' && level == 0) {
                groups.add(new ArrayList<>());
            } else if (level == 0) {
                groups.get(groups.size() - 1).add(Arrays.asList(String.valueOf(c)));
            }
        }

        Set<String> set = new TreeSet<>();
        for (List<List<String>> group : groups) {
            List<String> pre = new ArrayList<>();
            pre.add("");
            for (List<String> g : group) {
                List<String> tmp = new ArrayList<>();
                for (String pStr : pre) {
                    for (String gStr : g) {
                        tmp.add(pStr + gStr);
                    }
                }
                pre = tmp;
            }
            set.addAll(pre);
        }
        return new ArrayList<>(set);
    }
}
