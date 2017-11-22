package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/my-calendar-i/
 */
public class Problem729 {
    private static class MyCalendar {
        private final List<int[]> list = new ArrayList<>();

        public MyCalendar() {
        }

        public boolean book(int start, int end) {
            for (int[] i : list) {
                if (i[0] < end && start < i[1]) {
                    return false;
                }
            }
            list.add(new int[]{start, end});
            return true;
        }
    }
}
