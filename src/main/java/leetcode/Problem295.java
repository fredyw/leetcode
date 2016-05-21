package leetcode;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
public class Problem295 {
    static class MedianFinder {

        // Adds a number into the data structure.
        public void addNum(int num) {
            // TODO:
        }

        // Returns the median of current data stream
        public double findMedian() {
            // TODO:
            return 0;
        }
    }

    public static void main(String[] args) {
        MedianFinder med = new MedianFinder();
        med.addNum(1);
        med.addNum(2);
        System.out.println(med.findMedian()); // 1.5
        med.addNum(3);
        System.out.println(med.findMedian()); // 2
    }
}
