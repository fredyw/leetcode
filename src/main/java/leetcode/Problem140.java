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
        Set<String> words = new HashSet<>();
        for (String word : wordDict) {
            words.add(word);
        }
        List<String> result = new ArrayList<>();
        wordBreak(s, words, 0, 1, new ArrayList<>(), result);
        return result;
    }

    private static void wordBreak(String s, Set<String> words, int i, int j, List<String> tmp,
                                  List<String> result) {
        if (j > s.length()) {
            if (i == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < tmp.size(); k++) {
                    if (k == 0) {
                        sb.append(tmp.get(k));
                    } else {
                        sb.append(" " + tmp.get(k));
                    }
                }
                result.add(sb.toString());
            }
            return;
        }
        String sub = s.substring(i, j);
        if (words.contains(sub)) {
            tmp.add(sub);
            wordBreak(s, words, j, j + 1, tmp, result);
            tmp.remove(tmp.size() - 1);
        }
        wordBreak(s, words, i, j + 1, tmp, result);
    }

    public static void main(String[] args) {
        Problem140 prob = new Problem140();
        System.out.println(prob.wordBreak("catsanddog",
            Arrays.asList("cat", "cats", "and", "sand", "dog"))); // ["cats and dog", "cat sand dog"]
        System.out.println(prob.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }
}
