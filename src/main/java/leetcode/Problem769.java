package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted/
 */
public class Problem769 {
    public int maxChunksToSorted(int[] arr) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        int result = 0;
        int i = 0;
        int j = i;
        while (i < sorted.length) {
            while (j < arr.length && arr[j] != sorted[i]) {
                j++;
            }
            i = j;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem769 prob = new Problem769();
//        System.out.println(prob.maxChunksToSorted(new int[]{4, 3, 2, 1, 0})); // 1
//        System.out.println(prob.maxChunksToSorted(new int[]{1, 0, 2, 3, 4})); // 4
//        System.out.println(prob.maxChunksToSorted(new int[]{1, 0, 1, 2, 3, 4})); // 5
        System.out.println(prob.maxChunksToSorted(new int[]{2, 0, 1})); // 1
        System.out.println(prob.maxChunksToSorted(new int[]{2, 0, 1, 5})); // 2
//        System.out.println(prob.maxChunksToSorted(new int[]{1, 2})); // 2
//        System.out.println(prob.maxChunksToSorted(new int[]{2, 1})); // 1
    }
}
