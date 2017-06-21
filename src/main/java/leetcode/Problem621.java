package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/task-scheduler/
 */
public class Problem621 {
    public int leastInterval(char[] tasks, int n) {
        int result = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            if (!charCountMap.containsKey(tasks[i])) {
                charCountMap.put(tasks[i], 1);
            } else {
                charCountMap.put(tasks[i], charCountMap.get(tasks[i]) + 1);
            }
        }
        PriorityQueue<CharCount> queue = new PriorityQueue<>((a, b) -> {
            int cmp = Integer.compare(b.count, a.count);
            if (cmp == 0) {
                return Integer.compare(a.ch, b.ch);
            }
            return cmp;
        });
        charCountMap.forEach((ch, count) -> queue.add(new CharCount(ch, count)));
        boolean[] processed = new boolean[26];
        int processedCount = 0;
        List<CharCount> tmp = new ArrayList<>();
        while (!queue.isEmpty()) {
            boolean found = false;
            CharCount charCount = null;
            while (!queue.isEmpty()) {
                charCount = queue.poll();
                if (processed[charCount.ch - 'A']) {
                    tmp.add(charCount);
                    continue;
                }
                found = true;
                break;
            }
            if (!found) {
                result += n - processedCount + 1;
                processed = new boolean[26];
                processedCount = 0;
            } else {
                charCount.count--;
                if (charCount.count > 0) {
                    queue.add(charCount);
                }
                processed[charCount.ch - 'A'] = true;
                processedCount++;
                if (processedCount == n + 1) {
                    processed = new boolean[26];
                    processedCount = 0;
                }
                result++;
            }
            for (CharCount cc : tmp) {
                queue.add(cc);
            }
            tmp.clear();
        }
        return result;
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
