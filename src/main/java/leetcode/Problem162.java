package leetcode;

/**
 * https://leetcode.com/problems/find-peak-element/
 */
public class Problem162 {
    public int findPeakElement(int[] num) {
        return findPeakElement(num, num.length - 1, 0);
    }

    private int findPeakElement(int[] num, int left, int right) {
        if (right >= left) {
            return right;
        }
        int mid = (left + right) / 2;
        if (num[mid] < num[mid + 1]) {
            return findPeakElement(num, left, mid + 1);
        } else {
            return findPeakElement(num, mid, right);
        }
    }
}
