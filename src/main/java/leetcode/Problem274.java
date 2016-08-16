package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/h-index/
 */
public class Problem274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int h = n; h >= 0; h--) {
            int idx = binarySearch(citations, h, 0, n - 1);
            int x = n - idx;
            if (x >= h) {
                return h;
            }
        }
        return 0;
    }

    private int binarySearch(int[] citations, int val, int lo, int hi) {
        if (lo > hi) {
            return lo;
        }
        int mid = (lo + hi) / 2;
        if (citations[mid] == val) {
            int newMid = mid;
            while (newMid >= 0 && citations[newMid] == val) {
                newMid--;
            }
            return ++newMid;
        }
        if (citations[mid] > val) {
            return binarySearch(citations, val, lo, mid - 1);
        }
        return binarySearch(citations, val, mid + 1, hi);
    }
}
