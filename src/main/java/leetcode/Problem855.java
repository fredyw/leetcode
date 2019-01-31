package leetcode;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/exam-room/
 */
public class Problem855 {
    private static class ExamRoom {
        private final int n;
        private final TreeSet<Integer> set = new TreeSet<>();

        public ExamRoom(int N) {
            this.n = N;
        }

        public int seat() {
            if (set.isEmpty()) {
                set.add(0);
                return 0;
            }
            int prevIdx = 0;
            int newIdx = 0;
            int max = 0;
            for (int i : set) {
                int mid = (i - prevIdx) / 2;
                if (max < mid) {
                    max = mid;
                    newIdx = prevIdx + mid;
                }
                prevIdx = i;
            }
            if (!set.contains(0)) {
                int diff = set.first();
                if (max <= diff) {
                    newIdx = 0;
                }
            }
            if (!set.contains(n - 1)) {
                int diff = n - 1 - prevIdx;
                if (max < diff) {
                    newIdx = n - 1;
                }
            }
            set.add(newIdx);
            return newIdx;
        }

        public void leave(int p) {
           set.remove(p);
        }
    }

    public static void main(String[] args) {
        ExamRoom room = new ExamRoom(10);
//        System.out.println(room.seat()); // 0
//        System.out.println(room.seat()); // 9
//        System.out.println(room.seat()); // 4
//        System.out.println(room.seat()); // 2
//        room.leave(4);
//        System.out.println(room.seat()); // 5
//        System.out.println(room.seat()); // 7
//        System.out.println(room.seat()); // 1
//        System.out.println(room.seat()); // 3

//        System.out.println(room.seat()); // 0
//        System.out.println(room.seat()); // 9
//        System.out.println(room.seat()); // 4
//        room.leave(9);
//        System.out.println(room.seat()); // 9

//        System.out.println(room.seat()); // 0
//        System.out.println(room.seat()); // 9
//        System.out.println(room.seat()); // 4
//        room.leave(0);
//        System.out.println(room.seat()); // 0

        System.out.println(room.seat()); // 0
        System.out.println(room.seat()); // 9
        System.out.println(room.seat()); // 4
        room.leave(0);
        room.leave(4);
        System.out.println(room.seat()); // 0
        System.out.println(room.seat()); // 4
        System.out.println(room.seat()); // 2
        System.out.println(room.seat()); // 6
        System.out.println(room.seat()); // 1
        System.out.println(room.seat()); // 3
        System.out.println(room.seat()); // 5
        System.out.println(room.seat()); // 7
        System.out.println(room.seat()); // 8
        room.leave(0);
        room.leave(4);
        System.out.println(room.seat()); // 0
        System.out.println(room.seat()); // 4
    }
}
