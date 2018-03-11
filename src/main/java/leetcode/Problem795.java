package leetcode;

/**
 * https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
 */
public class Problem795 {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int result = 0;
        int count = 0;
        int max = -1;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            if (L <= max && max <= R) {
                count++;
            } else {
                max = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem795 prob = new Problem795();
        System.out.println(prob.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3)); // 3
        System.out.println(prob.numSubarrayBoundedMax(new int[]{1, 1, 1, 1}, 2, 3)); // 0
        System.out.println(prob.numSubarrayBoundedMax(new int[]{1, 1, 2, 1}, 2, 3)); // 6
        System.out.println(prob.numSubarrayBoundedMax(new int[]{1, 2, 1}, 2, 3)); // 4
        System.out.println(prob.numSubarrayBoundedMax(new int[]{1, 1, 2, 1, 1}, 2, 3)); // 9
        System.out.println(prob.numSubarrayBoundedMax(new int[]{1, 3, 2, 1, 1}, 2, 3)); // 11
        System.out.println(prob.numSubarrayBoundedMax(new int[]{1, 3, 2, 3, 1}, 2, 3)); // 13
        System.out.println(prob.numSubarrayBoundedMax(new int[]{1, 1, 2, 1, 1, 4, 1, 2, 1}, 2, 3)); // 13
        System.out.println(prob.numSubarrayBoundedMax(new int[]{1, 1, 2, 3, 1, 4, 1, 2, 1}, 2, 3)); // 15
    }
}
