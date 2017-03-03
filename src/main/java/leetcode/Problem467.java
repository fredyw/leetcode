package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-substrings-in-wraparound-string/
 */
public class Problem467 {
    public int findSubstringInWraproundString(String p) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < p.length(); i++) {
            int j = i;
            while (j + 1 < p.length() && (p.charAt(j) + 1 - 'a') % 26 == p.charAt(j + 1) - 'a') {
                j++;
            }
            String sub = p.substring(i, j + 1);
            if (!set.contains(sub.toString())) {
                set.add(sub.toString());
                substrings(sub.toString(), set);
            }
            i = j;
        }
        return set.size();
    }

    private static void substrings(String s, Set<String> set) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                set.add(s.substring(i, j));
            }
        }
    }

    public static void main(String[] args) {
        Problem467 prob = new Problem467();
        System.out.println(prob.findSubstringInWraproundString("a")); // 1
        System.out.println(prob.findSubstringInWraproundString("cac")); // 2
        System.out.println(prob.findSubstringInWraproundString("zab")); // 6
        System.out.println(prob.findSubstringInWraproundString("cab")); // 4
        System.out.println(prob.findSubstringInWraproundString("dabd")); // 4
        System.out.println(prob.findSubstringInWraproundString("zaba")); // 6
        System.out.println(prob.findSubstringInWraproundString("abcd")); // 10
        System.out.println(prob.findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyz")); // 351
        System.out.println(prob.findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz")); // 11843
    }
}
