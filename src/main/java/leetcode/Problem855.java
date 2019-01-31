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
            if (set.size() == 1) {
                int i = set.first();
                int diff = n - i - 1;
                if (i >= diff) {
                    set.add(i);
                    return i;
                }
                set.add(n - 1);
                return n - 1;
            }
            int prevIdx = 0;
            int maxPrevIdx = 0;
            int maxCurIdx = 0;
            int max = 0;
            for (int i : set) {
                int mid = (i - prevIdx) / 2;
                if (max < mid) {
                    max = mid;
                    maxPrevIdx = prevIdx;
                    maxCurIdx = i;
                }
                prevIdx = i;
            }
            int newIdx = maxPrevIdx + ((maxCurIdx - maxPrevIdx) / 2);
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

        System.out.println(room.seat()); // 0
        System.out.println(room.seat()); // 9
        System.out.println(room.seat()); // 4
        room.leave(9);
        System.out.println(room.seat()); // 9
    }
}
