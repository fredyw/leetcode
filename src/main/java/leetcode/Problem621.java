package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

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
        Set<Character> processed = new HashSet<>();
        List<CharCount> tmp = new ArrayList<>();
        while (!queue.isEmpty()) {
            boolean found = false;
            CharCount charCount = null;
            while (!queue.isEmpty()) {
                charCount = queue.poll();
                if (processed.contains(charCount.ch)) {
                    tmp.add(charCount);
                    continue;
                }
                found = true;
                break;
            }
            if (!found) {
                result += n - processed.size() + 1;
                processed.clear();
            } else {
                charCount.count--;
                if (charCount.count > 0) {
                    queue.add(charCount);
                }
                processed.add(charCount.ch);
                if (processed.size() == n + 1) {
                    processed.clear();
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

        @Override
        public String toString() {
            return ch + " -> " + count;
        }
    }

    public static void main(String[] args) {
        Problem621 prob = new Problem621();
        System.out.println(prob.leastInterval(new char[]{'A','A','A','B','B','B'}, 2)); // 8
        System.out.println(prob.leastInterval(new char[]{'A','A','A','B','B','B'}, 1)); // 6
        System.out.println(prob.leastInterval(new char[]{'A','A','A','B','B','B'}, 3)); // 10
        System.out.println(prob.leastInterval(new char[]{'A','B','B','B'}, 2)); // 7
        System.out.println(prob.leastInterval(new char[]{'A','B','B','B'}, 1)); // 5
        System.out.println(prob.leastInterval(new char[]{'A','B','C'}, 1)); // 3
        System.out.println(prob.leastInterval(new char[]{'A','B','C'}, 2)); // 3
        System.out.println(prob.leastInterval(new char[]{'A','B','C'}, 3)); // 3
        System.out.println(prob.leastInterval(new char[]{'A','B','C','A'}, 3)); // 5
        System.out.println(prob.leastInterval(new char[]{'A','B','C','A','C'}, 3)); // 6
        System.out.println(prob.leastInterval(new char[]{'A','B','C','D','C'}, 3)); // 5
        System.out.println(prob.leastInterval(new char[]{'A','B','B','C','C','D','D','D','E'}, 3)); // 9
        System.out.println(prob.leastInterval(new char[]{'A','B','B','C','C','D','D','D','E'}, 4)); // 11
    }
}
