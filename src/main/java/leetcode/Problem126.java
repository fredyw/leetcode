package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 */
public class Problem126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Map<String, List<String>> path = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Map<String, Integer> dist = new HashMap<>();
        dist.put(beginWord, 0);
        while (!queue.isEmpty()) {
            String word = queue.remove();
            if (word.equals(endWord)) {
                break;
            }
            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String newWord = new String(chars);
                    if (words.contains(newWord)) {
                        if (dist.getOrDefault(word, Integer.MAX_VALUE) + 1 <
                            dist.getOrDefault(newWord, Integer.MAX_VALUE)) {
                            dist.put(newWord, dist.get(word) + 1);
                            List<String> list = path.getOrDefault(newWord, new ArrayList<>());
                            list.add(word);
                            path.put(newWord, list);
                            queue.add(newWord);
                        } else if (dist.getOrDefault(word, Integer.MAX_VALUE) + 1 ==
                            dist.getOrDefault(newWord, Integer.MAX_VALUE)) {
                            path.get(newWord).add(word);
                        }
                    }
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        if (path.get(endWord) == null) {
            return result;
        }
        buildResult(path, endWord, Arrays.asList(endWord), result);
        return result;
    }

    private static void buildResult(Map<String, List<String>> path,
                                    String word,
                                    List<String> accu,
                                    List<List<String>> result) {
        List<String> words = path.get(word);
        if (words == null) {
            Collections.reverse(accu);
            result.add(accu);
            return;
        }
        for (String w : words) {
            List<String> newAccu = new ArrayList<>(accu);
            newAccu.add(w);
            buildResult(path, w, newAccu, result);
        }
    }
}
