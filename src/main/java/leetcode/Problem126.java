package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 */
public class Problem126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        for (String word : wordList) {
            words.add(word);
        }
        List<List<String>> result = new ArrayList<>();
        Min min = new Min();
        findLadders(beginWord, endWord, words, new ArrayList<>(), min, result);
        Iterator<List<String>> iter = result.iterator();
        while (iter.hasNext()) {
            List<String> list = iter.next();
            if (list.size() != min.val) {
                iter.remove();
            }
        }
        return result;
    }

    private static class Min {
        private int val = Integer.MAX_VALUE;
    }

    private static void findLadders(String startWord,
                                    String endWord,
                                    Set<String> words,
                                    List<String> accu,
                                    Min min,
                                    List<List<String>> result) {
        accu.add(startWord);
        for (int i = 0; i < startWord.length(); i++) {
            char[] chars = startWord.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String newString = new String(chars);
                if (newString.equals(endWord)) {
                    accu.add(endWord);
                    result.add(accu);
                    min.val = Math.min(min.val, accu.size());
                    return;
                }
                if (words.contains(newString)) {
                    List<String> newAccu = new ArrayList<>(accu);
                    words.remove(newString);
                    findLadders(newString, endWord, words, newAccu, min, result);
                    words.add(newString);
                }
            }
        }
    }

    public static void main(String[] args) {
        Problem126 prob = new Problem126();

        System.out.println(prob.findLadders("foo", "baz", Arrays.asList("buz", "bug", "bud", "bar", "fuz", "foz",
            "faz", "gaz", "boz"))); // [[foo, foz, boz, baz], [foo, foz, faz, baz]]

        System.out.println(prob.findLadders("bar", "baz", Arrays.asList("buz", "bug", "bud", "bar", "fuz", "foz",
            "faz", "gaz", "boz"))); // [[bar, baz]]
    }
}
