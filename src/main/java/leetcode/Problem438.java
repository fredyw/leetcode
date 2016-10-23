package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class Problem438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] sortedP = p.toCharArray();
        Arrays.sort(sortedP);
        for (int i = 0; i < s.length(); i++) {
            if (i + p.length() > s.length()) {
                break;
            }
            char[] sortedSub = s.substring(i, i + p.length()).toCharArray();
            Arrays.sort(sortedSub);
            if (Arrays.equals(sortedP, sortedSub)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem438 prob = new Problem438();
        System.out.println(prob.findAnagrams("cbaebabacd", "abc")); // [0, 6]
        System.out.println(prob.findAnagrams("abab", "ab")); // [0, 1, 2]
    }
}
