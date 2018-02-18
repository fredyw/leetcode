package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/word-break-ii/
 */
public class Problem140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem140 prob = new Problem140();
        System.out.println(prob.wordBreak("catsanddog",
            Arrays.asList("cat", "cats", "and", "sand", "dog"))); // ["cats and dog", "cat sand dog"]
    }
}
