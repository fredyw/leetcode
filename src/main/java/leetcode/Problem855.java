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
            // TODO
            return 0;
        }

        public void leave(int p) {
            // TODO
        }
    }

    public static void main(String[] args) {
        ExamRoom room = new ExamRoom(10);
        System.out.println(room.seat()); // 0
        System.out.println(room.seat()); // 9
        System.out.println(room.seat()); // 4
        System.out.println(room.seat()); // 2
        room.leave(4);
        System.out.println(room.seat()); // 5
    }
}
