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
            int count = 0;
            for (int[] i : list) {
                if (i[0] < end && start < i[1]) {
                    if (count > 1) {
                        return false;
                    }
                    count++;
                }
            }
            if (count > 1) {
                return false;
            }
            list.add(new int[]{start, end});
            return true;
        }
    }

    public static void main(String[] args) {
        MyCalendarTwo calendar = new MyCalendarTwo();
//        System.out.println(calendar.book(1, 10)); // true
//        System.out.println(calendar.book(8, 17)); // true
//        System.out.println(calendar.book(2, 7)); // true

//        System.out.println(calendar.book(1, 10)); // true
//        System.out.println(calendar.book(6, 9)); // true
//        System.out.println(calendar.book(7, 8)); // false

        System.out.println(calendar.book(10, 20)); // true
        System.out.println(calendar.book(50, 60)); // true
        System.out.println(calendar.book(10, 40)); // true
        System.out.println(calendar.book(5, 15)); // false
        System.out.println(calendar.book(20, 30)); // true
        System.out.println(calendar.book(5, 10)); // true
        System.out.println(calendar.book(25, 55)); // true

//        System.out.println(calendar.book(47, 50));
//        System.out.println(calendar.book(1, 10));
//        System.out.println(calendar.book(27, 36));
//        System.out.println(calendar.book(40, 47));
//        System.out.println(calendar.book(20, 27));
//        System.out.println(calendar.book(15, 23));
//        System.out.println(calendar.book(10, 18));
//        System.out.println(calendar.book(27, 36));
//        System.out.println(calendar.book(17, 25));
//        System.out.println(calendar.book(8, 17));
//        System.out.println(calendar.book(24, 33));
//        System.out.println(calendar.book(23, 28));
//        System.out.println(calendar.book(21, 27));
//        System.out.println(calendar.book(47, 50));
//        System.out.println(calendar.book(14, 21));
//        System.out.println(calendar.book(26, 32));
//        System.out.println(calendar.book(16, 21));
//        System.out.println(calendar.book(2, 7)); // true
    }
}
