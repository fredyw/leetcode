package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary/
 */
public class Problem720 {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> a.compareTo(b));
        String tmp = words[0];
        List<WordCount> result = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < words.length; i++) {
            if (tmp.length() + 1 == words[i].length() && words[i].startsWith(tmp)) {
                tmp = words[i];
                count++;
            } else {
                result.add(new WordCount(tmp, count));
                tmp = words[i];
                count = 1;
            }
        }
        result.add(new WordCount(tmp, count));
        result.sort((a, b) -> {
            if (a.count < b.count) {
                return 1;
            } else if (a.count > b.count) {
                return -1;
            } else {
                return a.word.compareTo(b.word);
            }
        });
        return result.get(0).word;
    }

    private static class WordCount {
        private String word;
        private int count;

        public WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public String toString() {
            return word + ": " + count;
        }
    }

    public static void main(String[] args) {
        Problem720 prob = new Problem720();
//        System.out.println(prob.longestWord(new String[]{"w","wo","wor","worl", "world"})); // world
//        System.out.println(prob.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"})); // apple
//        System.out.println(prob.longestWord(new String[]{"a"})); // a
//        System.out.println(prob.longestWord(new String[]{"a", "b"})); // a
//        System.out.println(prob.longestWord(new String[]{"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"})); // latte
        System.out.println(prob.longestWord(new String[]{"ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"})); // eyj
    }
}
