package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
 */
public class Problem1031 {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        LeftRight lr = new LeftRight();
        int lSum = maxSum(A, L, lr);
        int[] newArray = new int[A.length - L];
        int idx = 0;
        for (int i = 0; i < A.length; i++) {
            if (lr.left <= i && i <= lr.right) {
                continue;
            }
            newArray[idx++] = A[i];
        }
        int mSum = maxSum(newArray, M, lr);
        return lSum + mSum;
    }

    private static class LeftRight {
        private int left;
        private int right;
    }

    private static int maxSum(int[] a, int size, LeftRight lr) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += a[i];
        }
        int max = sum;
        int i = size - 1;
        int[] sums = new int[a.length];
        sums[i++] = sum;
        for (int j = 0; i < a.length; i++, j++) {
            sum += a[i] - a[j];
            sums[i] = sum;
            if (max < sum) {
                max = sum;
                lr.left = j + 1;
                lr.right = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem1031 prob = new Problem1031();
        System.out.println(prob.maxSumTwoNoOverlap(new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2)); // 20
        System.out.println(prob.maxSumTwoNoOverlap(new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0}, 3, 2)); // 29
        System.out.println(prob.maxSumTwoNoOverlap(new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3)); // 31
        System.out.println(prob.maxSumTwoNoOverlap(new int[]{4, 0, 1}, 2, 1)) // 5
    }
}
