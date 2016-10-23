package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class Problem438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        // TODO
        return result;
    }

    public static void main(String[] args) {
        Problem438 prob = new Problem438();
        System.out.println(prob.findAnagrams("cbaebabacd", "abc")); // [0, 6]
        System.out.println(prob.findAnagrams("abab", "ab")); // [0, 1, 2]
    }
}
