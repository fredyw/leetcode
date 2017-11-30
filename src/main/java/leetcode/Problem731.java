package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/my-calendar-ii/
 */
public class Problem731 {
    private static class MyCalendarTwo {
        private final List<int[]> list = new ArrayList<>();
        private final List<int[]> booked = new ArrayList<>();

        public MyCalendarTwo() {
        }

        public boolean book(int start, int end) {
            for (int[] i : booked) {
                if (i[0] < end && start < i[1]) {
                    return false;
                }
            }
            for (int[] i : list) {
                if (i[0] < end && start < i[1]) {
                    booked.add(new int[]{Math.max(i[0], start), Math.min(end, i[1])});
                }
            }
            list.add(new int[]{start, end});
            return true;
        }
    }
}
