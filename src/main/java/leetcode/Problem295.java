package leetcode;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
public class Problem295 {
    static class MedianFinder {
        private final TreeSet<Integer> set = new TreeSet<>((a, b) -> {
            if (a.intValue() <= b.intValue()) {
                return -1;
            } else {
                return 1;
            }
        });

        // Adds a number into the data structure.
        public void addNum(int num) {
            set.add(num);
        }

        // Returns the median of current data stream
        public double findMedian() {
            Integer[] array = set.toArray(new Integer[0]);
            int mid = array.length / 2;
            if (array.length % 2 == 0) {
                int a = array[mid - 1];
                int b = array[mid];
                return (a + b) / 2.0;
            }
            return array[mid];
        }
    }

    public static void main(String[] args) {
        MedianFinder med = new MedianFinder();
        med.addNum(1);
        System.out.println(med.findMedian()); // 1
        med.addNum(2);
        System.out.println(med.findMedian()); // 1.5
        med.addNum(3);
        System.out.println(med.findMedian()); // 2
    }
}
