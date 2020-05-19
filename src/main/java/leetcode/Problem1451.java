package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rearrange-words-in-a-sentence/
 */
public class Problem1451 {
    public String arrangeWords(String text) {
        String[] split = text.toLowerCase().split(" ");
        Word[] words = new Word[split.length];
        for (int i = 0; i < words.length; i++) {
            words[i] = new Word(split[i], i);
        }
        Arrays.sort(words, (a, b) -> {
            if (a.word.length() < b.word.length()) {
                return -1;
            } else if (a.word.length() > b.word.length()) {
                return 1;
            }
            return Integer.compare(a.index, b.index);
        });
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                answer.append(("" + words[i].word.charAt(0)).toUpperCase() + words[i].word.substring(1));
            } else {
                answer.append(" ");
                answer.append(words[i].word);
            }
        }
        return answer.toString();
    }

    private static class Word {
        private final String word;
        private final int index;

        public Word(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }
}
