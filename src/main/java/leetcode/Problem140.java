package leetcode;

import java.util.ArrayList;
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
        List<String> result = new ArrayList<>();
        wordBreak(s, words, 0, 1, "", result);
        return result;
    }

    private static void wordBreak(String s, Set<String> words, int i, int j, String accu,
                                  List<String> result) {
        if (j > s.length()) {
            if (i == s.length()) {
                result.add(accu);
            }
            return;
        }
        String sub = s.substring(i, j);
        if (words.contains(sub)) {
            String newAccu = accu;
            if (newAccu.isEmpty()) {
                newAccu = sub;
            } else {
                newAccu += " " + sub;
            }
            wordBreak(s, words, j, j + 1, newAccu, result);
        }
        wordBreak(s, words, i, j + 1, accu, result);
    }

    public static void main(String[] args) {
        Problem140 prob = new Problem140();
        System.out.println(prob.wordBreak("catsanddog",
            Arrays.asList("cat", "cats", "and", "sand", "dog"))); // ["cats and dog", "cat sand dog"]
    }
}
