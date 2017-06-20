package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/task-scheduler/
 */
public class Problem621 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            if (!charCountMap.containsKey(tasks[i])) {
                charCountMap.put(tasks[i], 1);
            } else {
                charCountMap.put(tasks[i], charCountMap.get(tasks[i]) + 1);
            }
        }
        List<CharCount> charCountList = new ArrayList<>();
        charCountMap.forEach((key, value) -> {
            charCountList.add(new CharCount(key, value));
        });
        Collections.sort(charCountList, (a, b) -> Integer.compare(b.count, a.count));
        int result = 0;
        int count = 0;
        int i = 0;
        while (!charCountList.isEmpty()) {
            CharCount charCount = charCountList.get(i);
            charCount.count--;
            if (charCount.count == 0) {
                charCountList.remove(i);
                i--;
            }
            count++;
            result++;
            i++;
            if (i == 0) {
                break;
            }
            i = i % charCountList.size();
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
//        System.out.println(prob.leastInterval(new char[]{'A','A','A','B','B','B'}, 2)); // 8
//        System.out.println(prob.leastInterval(new char[]{'A','A','A','B','B','B'}, 1)); // 6
//        System.out.println(prob.leastInterval(new char[]{'A','A','A','B','B','B'}, 3)); // 10
//        System.out.println(prob.leastInterval(new char[]{'A','B','B','B'}, 2)); // 7
//        System.out.println(prob.leastInterval(new char[]{'A','B','B','B'}, 1)); // 5
//        System.out.println(prob.leastInterval(new char[]{'A','B','C'}, 1)); // 3
//        System.out.println(prob.leastInterval(new char[]{'A','B','C'}, 2)); // 3
//        System.out.println(prob.leastInterval(new char[]{'A','B','C'}, 3)); // 3
//        System.out.println(prob.leastInterval(new char[]{'A','B','C','A'}, 3)); // 4
//        System.out.println(prob.leastInterval(new char[]{'A','B','C','A','C'}, 3)); // 6
//        System.out.println(prob.leastInterval(new char[]{'A','B','C','D','C'}, 3)); // 5
//        System.out.println(prob.leastInterval(new char[]{'A','B','B','C','C','D','D','D','E'}, 3)); // 9
        System.out.println(prob.leastInterval(new char[]{'A','B','B','C','C','D','D','D','E'}, 4)); // 11
    }
}
