package leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/longest-happy-string/
 */
public class Problem1405 {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<CharCount> queue = new PriorityQueue<>(
            (e1, e2) -> Integer.compare(e2.count, e1.count));
        if (a > 0) {
            queue.add(new CharCount('a', a));
        }
        if (b > 0) {
            queue.add(new CharCount('b', b));
        }
        if (c > 0) {
            queue.add(new CharCount('c', c));
        }
        StringBuilder answer = new StringBuilder();
        CharCount prev = null;
        while (!queue.isEmpty()) {
            CharCount current = queue.poll();
            if (prev != null && current.ch == prev.ch && prev.count == 2) {
                if (queue.isEmpty()) {
                    break;
                }
                CharCount next = queue.poll();
                queue.add(current);
                current = next;
            }
            answer.append(current.ch);
            current.count--;
            if (current.count > 0) {
                queue.add(current);
            }
            if (prev != null && prev.ch == current.ch) {
                prev.count++;
            } else {
                prev = new CharCount(current.ch, 1);
            }
        }
        return answer.toString();
    }

    private static class CharCount {
        private final char ch;
        private int count;

        public CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
