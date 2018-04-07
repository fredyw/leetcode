package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/expressive-words/
 */
public class Problem809 {
    public int expressiveWords(String S, String[] words) {
        List<CharCount> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (i == 0) {
                count++;
                continue;
            }
            if (S.charAt(i - 1) != S.charAt(i)) {
                list.add(new CharCount(S.charAt(i - 1), count));
                count = 1;
            } else {
                count++;
            }
        }
        if (S.length() > 0) {
            list.add(new CharCount(S.charAt(S.length() - 1), count));
        }
        int result = 0;
        for (String word : words) {
            count = 0;
            int index = 0;
            boolean found = true;
            for (int i = 0; i < word.length(); i++) {
                if (i == 0) {
                    count++;
                    continue;
                }
                if (word.charAt(i - 1) != word.charAt(i)) {
                    if (index >= list.size()) {
                        found = false;
                        break;
                    }
                    CharCount cc = list.get(index++);
                    if (cc.ch != word.charAt(i - 1) || cc.count < count ||
                        (cc.count != count && cc.count < 3)) {
                        found = false;
                        break;
                    }
                    count = 1;
                } else {
                    count++;
                }
            }
            if (index < list.size()) {
                CharCount cc = list.get(index++);
                if (word.length() == 0) {
                    found = false;
                } else {
                    if (cc.ch != word.charAt(word.length() - 1) || cc.count < count ||
                        (cc.count != count && cc.count < 3)) {
                        found = false;
                    }
                }
            }
            if (found && index == list.size()) {
                result++;
            }
        }
        return result;
    }

    private static class CharCount {
        private final char ch;
        private final int count;

        public CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
