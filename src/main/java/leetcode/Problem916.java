package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-subsets/
 */
public class Problem916 {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList<>();
        outer:
        for (String a : A) {
            for (String b : B) {
                int[] counts = new int[26];
                for (char c : a.toCharArray()) {
                    counts[c - 'a']++;
                }
                for (char c : b.toCharArray()) {
                    if (counts[c - 'a'] == 0) {
                        continue outer;
                    }
                    counts[c - 'a']--;
                }
            }
            result.add(a);
        }
        return result;
    }

    public static void main(String[] args) {
        Problem916 prob = new Problem916();
        System.out.println(prob.wordSubsets(
            new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
            new String[]{"e", "o"})); // ["facebook","google","leetcode"]
        System.out.println(prob.wordSubsets(
            new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
            new String[]{"l", "e"})); // ["apple","google","leetcode"]
        System.out.println(prob.wordSubsets(
            new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
            new String[]{"e", "oo"})); // ["facebook","google"]
        System.out.println(prob.wordSubsets(
            new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
            new String[]{"lo", "eo"})); // ["google","leetcode"]
        System.out.println(prob.wordSubsets(
            new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
            new String[]{"ec", "oc", "ceo"})); // ["facebook","leetcode"]
    }
}
