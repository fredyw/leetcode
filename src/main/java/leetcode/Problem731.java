package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/my-calendar-ii/
 */
public class Problem731 {
    private static class MyCalendarTwo {
        private final List<int[]> list = new ArrayList<>();

        public MyCalendarTwo() {
        }

        public boolean book(int start, int end) {
            for (int[] i : list) {
                if (i[0] < end && start < i[1]) {
                    if (i[2] >= 1) {
                        return false;
                    } else {
                        i[2]++;
                    }
                }
            }
            list.add(new int[]{start, end, 1});
            return true;
        }
    }

    public static void main(String[] args) {
        MyCalendarTwo calendar = new MyCalendarTwo();
        System.out.println(calendar.book(10, 20)); // true
        System.out.println(calendar.book(50, 60)); // true
        System.out.println(calendar.book(10, 40)); // true
        System.out.println(calendar.book(5, 15)); // false
        System.out.println(calendar.book(5, 10)); // true
        System.out.println(calendar.book(25, 55)); // true
    }
}
