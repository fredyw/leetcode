package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/reorganize-string/
 */
public class Problem767 {
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            if (!map.containsKey(S.charAt(i))) {
                map.put(S.charAt(i), 1);
            } else {
                map.put(S.charAt(i), map.get(S.charAt(i)) + 1);
            }
        }
        PriorityQueue<CharCount> queue = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            queue.add(new CharCount(e.getKey(), e.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            CharCount charCount = queue.remove();
            if (sb.length() == 0) {
                sb.append(charCount.ch);
            } else {
                CharCount tmp = charCount;
                if (!queue.isEmpty() && charCount.ch == sb.charAt(sb.length() - 1)) {
                    charCount = queue.remove();
                    queue.add(tmp);
                }
                if (charCount.ch == sb.charAt(sb.length() - 1)) {
                    return "";
                }
                sb.append(charCount.ch);
            }
            charCount.count--;
            if (charCount.count > 0) {
                queue.add(charCount);
            }
        }
        return sb.toString();
    }

    private static class CharCount {
        private char ch;
        private int count;

        public CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
