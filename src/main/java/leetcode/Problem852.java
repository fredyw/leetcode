package leetcode;

/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */
public class Problem852 {
    public int peakIndexInMountainArray(int[] A) {
        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
