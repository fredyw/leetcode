package leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/my-calendar-iii/
 */
public class Problem732 {
    private static class MyCalendarThree {
        private final Map<Integer/*num*/, Integer/*count*/> delta = new TreeMap<>();

        public MyCalendarThree() {
        }

        public int book(int start, int end) {
            delta.put(start, delta.getOrDefault(start, 0) + 1); // increment start count
            delta.put(end, delta.getOrDefault(end, 0) - 1); // decrement end count

            int count = 0;
            int max = 0;
            for (int d : delta.values()) {
                count += d;
                max = Math.max(max, count);
            }
            return max;
        }
    }
}
