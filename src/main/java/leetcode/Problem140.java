package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break-ii/
 */
public class Problem140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // TODO
        Set<String> words = new HashSet<>();
        for (String word : wordDict) {
            words.add(word);
        }
        return null;
    }

    public static void main(String[] args) {
        Problem140 prob = new Problem140();
        System.out.println(prob.wordBreak("catsanddog",
            Arrays.asList("cat", "cats", "and", "sand", "dog"))); // ["cats and dog", "cat sand dog"]
    }
}
