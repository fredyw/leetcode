package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/count-binary-substrings/
 */
public class Problem696 {
    public int countBinarySubstrings(String s) {
        List<CharCount> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (list.isEmpty()) {
                list.add(new CharCount(s.charAt(i), 1));
            } else {
                CharCount cc = list.get(list.size() - 1);
                if (cc.ch == s.charAt(i)) {
                    cc.count++;
                } else {
                    list.add(new CharCount(s.charAt(i), 1));
                }
            }
        }
        int result = 0;
        for (int i = 0, j = 1; j < list.size(); i++, j++) {
            result += Math.min(list.get(i).count, list.get(j).count);
        }
        return result;
    }

    private static final class CharCount {
        private final char ch;
        private int count;

        public CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
