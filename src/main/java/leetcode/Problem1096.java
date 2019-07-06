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

    public static void main(String[] args) {
        Problem1096 prob = new Problem1096();
        System.out.println(prob.braceExpansionII("{a{b,c}d{e,f}}")); // ["abde",abdf","acde","acdf"]
//        System.out.println(prob.braceExpansionII("a{b,c}")); // ["ab","ac"]
//        System.out.println(prob.braceExpansionII("{c{d,e}f}")); // ["cdf","cef"]
//        System.out.println(prob.braceExpansionII("{a,b}{c{d,e}}")); // ["acd","ace","bcd","bce"]
//        System.out.println(prob.braceExpansionII("{{a,z},a{b,c},{ab,z}}")); // ["a","ab","ac","z"]
//        System.out.println(prob.braceExpansionII("{a,b,c}")); // ["a","b","c"]
//        System.out.println(prob.braceExpansionII("{{a,b},{b,c}}")); // ["a","b","c"]
//        System.out.println(prob.braceExpansionII("{a,b}{c,d}")); // ["ac","ad","bc","bd"]
//        System.out.println(prob.braceExpansionII("{a{b,c}}{{d,e}f{g,h}}")); // ["abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"]
    }
}
