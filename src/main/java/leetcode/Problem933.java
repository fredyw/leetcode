package leetcode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/number-of-recent-calls/
 */
public class Problem933 {
    private static class RecentCounter {
        private final LinkedList<Integer> list = new LinkedList<>();

        public RecentCounter() {
        }

        public int ping(int t) {
            list.add(t);
            while (t - 3000 > list.peekFirst()) {
                list.removeFirst();
            }
            return list.size();
        }
    }
}
