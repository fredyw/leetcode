package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
 */
public class Problem524 {
    public String findLongestWord(String s, List<String> d) {
        // TODO
        return "";
    }

    public static void main(String[] args) {
        Problem524 prob = new Problem524();
        
        System.out.println(prob.findLongestWord(
            "abpcplea", Arrays.asList("ale", "apple", "monkey", "plea"))); // apple

        System.out.println(prob.findLongestWord(
            "abpcplea", Arrays.asList("a", "b", "c"))); // a
    }
}
