package leetcode;

/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted/
 */
public class Problem769 {
    public int maxChunksToSorted(int[] arr) {
        int result = 0;
        int j = 0;
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (i <= max) {
                continue;
            }
            while (j < arr.length && arr[j] != i) {
                max = Math.max(max, arr[j]);
                j++;
            }
            if (j < arr.length) {
                max = Math.max(max, arr[j]);
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem769 prob = new Problem769();
//        System.out.println(prob.maxChunksToSorted(new int[]{4, 3, 2, 1, 0})); // 1
//        System.out.println(prob.maxChunksToSorted(new int[]{1, 0, 2, 3, 4})); // 4
//        System.out.println(prob.maxChunksToSorted(new int[]{1, 3, 2, 0, 4})); // 2
//        System.out.println(prob.maxChunksToSorted(new int[]{2, 0, 1})); // 1
//        System.out.println(prob.maxChunksToSorted(new int[]{2, 0, 1, 3})); // 2
//        System.out.println(prob.maxChunksToSorted(new int[]{1, 2})); // 2
//        System.out.println(prob.maxChunksToSorted(new int[]{2, 1})); // 1
        System.out.println(prob.maxChunksToSorted(new int[]{1, 4, 3, 6, 0, 7, 8, 2, 5})); // 1
    }
}
