package leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/decode-ways/
 */
public class Problem91 {
    public int numDecodings(String s) {
        System.out.println("Input: " + s);
        Map<String, Set<String>> memo = new HashMap<>();
        Set<String> set = decode(s, memo);
        if (set.size() == 0) {
            return set.size();
        }
        System.out.println("Output:");
        for (String str : set) {
            System.out.println(str);
        }
        if (s.length() == 1) {
            return set.size();
        }
        return set.size() + 1;
    }

    private Set<String> decode(String s, Map<String, Set<String>> memo) {
        if (s.length() == 1) {
            Set<String> set = new HashSet<>();
            int i = Integer.parseInt(s);
            if (i >= 1 && i <= 9) {
                set.add(s);
            }
            return set;
        }
        if (s.length() == 2) {
            Set<String> set = new HashSet<>();
            int i = Integer.parseInt(s);
            if (i >= 10 && i <= 26) {
                set.add(s);
            }
            return set;
        }
        if (memo.containsKey(s)) {
            System.out.println("memo: " + s + " --> " + memo.get(s));
            return memo.get(s);
        }
        Set<String> result = new HashSet<>();
        for (int i = 0; i < s.length()-1; i++) {
            String left = s.substring(0, i+1);
            Set<String> leftSet = decode(left, memo);
            String right = s.substring(i+1);
            Set<String> rightSet = decode(right, memo);
            for (String l : leftSet) {
                for (String r : rightSet) {
                    if (!result.add(l + " " + r)) {
                        System.out.println("duplicate: " + l + " " + r);
                    }
                }
            }
        }
        memo.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        Problem91 prob = new Problem91();
//        System.out.println(prob.numDecodings("12")); // 2
//        System.out.println(prob.numDecodings("215")); // 3
//        System.out.println(prob.numDecodings("2135")); // 3
//        System.out.println(prob.numDecodings("2125")); // 5
//        System.out.println(prob.numDecodings("21215")); // 8
        System.out.println(prob.numDecodings("21105")); // 3
//        System.out.println(prob.numDecodings("6065812287883668764831544958683283296479682877898293612168136334983851946827579555449329483852397155"));
    }
}
