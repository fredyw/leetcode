package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 */
public class Problem692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, WordCount> wordCounts = new HashMap<>();
        for (String word : words) {
            if (!wordCounts.containsKey(word)) {
                wordCounts.put(word, new WordCount(word));
            } else {
                wordCounts.get(word).count++;
            }
        }
        List<WordCount> values = new ArrayList<>(wordCounts.values());
        Collections.sort(values, (a, b) -> {
            int cmp = Integer.compare(b.count, a.count);
            if (cmp == 0) {
                return a.word.compareTo(b.word);
            }
            return cmp;
        });
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(values.get(i).word);
        }
        return result;
    }

    private static class WordCount {
        private final String word;
        private int count;

        public WordCount(String word) {
            this.word = word;
        }
    }

    public static void main(String[] args) {
        Problem692 prob = new Problem692();
        System.out.println(prob.topKFrequent(new String[]{
            "i", "love", "leetcode", "i", "love", "coding"}, 2)); // ["i", "love"]
        System.out.println(prob.topKFrequent(new String[]{
            "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"
        }, 4)); // ["the", "is", "sunny", "day"]
    }
}
