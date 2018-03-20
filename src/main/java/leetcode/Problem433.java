package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-genetic-mutation/
 */
public class Problem433 {
    public int minMutation(String start, String end, String[] bank) {
        char[] chars = new char[]{'A', 'C', 'G', 'T'};
        Set<String> set = new HashSet<>();
        for (String s : bank) {
            set.add(s);
        }
        Queue<StringLevel> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int result = -1;
        queue.add(new StringLevel(start, 0));
        visited.add(start);
        while (!queue.isEmpty()) {
            StringLevel sl = queue.remove();
            if (sl.node.equals(end)) {
                result = sl.level;
                break;
            }
            for (int i = 0; i < sl.node.length(); i++) {
                for (char c : chars) {
                    char[] tmp = sl.node.toCharArray();
                    tmp[i] = c;
                    String adjacent = new String(tmp);
                    if (set.contains(adjacent)) {
                        if (!visited.contains(adjacent)) {
                            queue.add(new StringLevel(adjacent, sl.level + 1));
                            visited.add(adjacent);
                        }
                    }
                }
            }
        }
        return result;
    }

    private static class StringLevel {
        private final String node;
        private final int level;

        public StringLevel(String node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
