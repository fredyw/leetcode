package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
 */
public class Problem801 {
    public int minSwap(int[] A, int[] B) {
        int answer = 0;
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            while (i + 1 < A.length && A[i] < A[i + 1]) {
                i++;
            }
            while (j + 1 < B.length && B[j] < B[j + 1]) {
                j++;
            }
            boolean swap = (i + 1 < A.length && A[i] >= A[i + 1]) ||
                (j + 1 < B.length && B[j] >= B[j + 1]);
            if (swap) {
                if (i < j) {
                    swap(A, B, i + 1);
                    j = i;
                    answer++;
                } else if (i > j) {
                    swap(A, B, j + 1);
                    i = j;
                    answer++;
                } else {
                    swap(A, B, i + 1);
                    answer++;
                }
            }
            i++;
            j++;
        }
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
        return answer;
    }

    private static void swap(int[] a, int[] b, int i) {
        int tmp = a[i];
        a[i] = b[i];
        b[i] = tmp;
    }

    public static void main(String[] args) {
        Problem801 prob = new Problem801();
//        System.out.println(prob.minSwap(new int[]{1, 3, 5, 4}, new int[]{1, 2, 3, 7})); // 1
//        System.out.println(prob.minSwap(new int[]{1, 3, 5, 4, 8}, new int[]{1, 2, 3, 7, 5})); // 1
        System.out.println(prob.minSwap(new int[]{0, 4, 4, 5, 9}, new int[]{0, 1, 6, 8, 10})); // 1
    }
}
