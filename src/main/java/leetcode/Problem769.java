package leetcode;

/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted/
 */
public class Problem769 {
    public int maxChunksToSorted(int[] arr) {
        int result = 0;
        int j = 0;
        int max = -1;
        boolean[] found = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (found[i] && i <= max) {
                continue;
            }
            while (j < arr.length && arr[j] != i) {
                found[arr[j]] = true;
                max = Math.max(max, arr[j]);
                j++;
            }
            if (j < arr.length) {
                max = Math.max(max, arr[j]);
            }
            if (max == j) {
                result++;
            }
        }
        return result;
    }
}
