package leetcode;

/**
 * https://leetcode.com/problems/longest-mountain-in-array/
 */
public class Problem845 {
    public int longestMountain(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int left = -1;
        int right = -1;
        int i = 0;
        int prev = A[0];
        int result = 0;
        while (i < A.length) {
            if (prev < A[i]) {
                if (left >= 0 && right >= 0) {
                    result = Math.max(result, right - left + 1);
                    left = right;
                    right = -1;
                } else {
                    if (left == -1) {
                        left = i - 1;
                    }
                }
                prev = Math.max(prev, A[i]);
            } else if (prev > A[i]) {
                prev = Math.min(prev, A[i]);
                right = i;
            } else {
                left = -1;
                right = -1;
            }
            i++;
        }
        if (left >= 0 && right >= 0) {
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Problem845 prob = new Problem845();
//        System.out.println(prob.longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5})); // 5
//        System.out.println(prob.longestMountain(new int[]{2, 2, 2})); // 0
//        System.out.println(prob.longestMountain(new int[]{1, 1, 2, 3, 4, 2, 3, 2})); // 5
//        System.out.println(prob.longestMountain(new int[]{2, 1})); // 0
//        System.out.println(prob.longestMountain(new int[]{1, 2})); // 0
//        System.out.println(prob.longestMountain(new int[]{1, 2, 1})); // 3
//        System.out.println(prob.longestMountain(new int[]{1, 2, 2, 1})); // 0
//        System.out.println(prob.longestMountain(new int[]{1, 2, 2, 1, 5, 3, 6, 1, 0})); // 0
        System.out.println(prob.longestMountain(new int[]{7, 4, 8})); // 0
    }
}
