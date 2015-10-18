package leetcode;

/**
 * https://leetcode.com/problems/h-index-ii/
 */
public class Problem275 {
    public int hIndex(int[] citations) {
        int idx = binarySearch(citations, 0, citations.length-1);
        return citations.length - idx;
    }

    private int binarySearch(int[] citations, int lo, int hi) {
        if (lo > hi) {
            return lo;
        }
        int mid = (lo + hi) / 2;
        if (citations[mid] == citations.length-mid) {
            return mid;
        }
        if (citations[mid] > citations.length-mid) {
            return binarySearch(citations, lo, mid-1);
        }
        return binarySearch(citations, mid+1, hi);
    }
}
