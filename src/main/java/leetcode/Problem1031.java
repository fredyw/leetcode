package leetcode;

/**
 * https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
 */
public class Problem1031 {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int answer = 0;
        int lSum = 0;
        for (int i = 0; i < L && i < A.length; i++) {
            lSum += A[i];
        }
        int right = L;
        int left = 0;
        for (; right < A.length; right++, left++) {
            int mSum = maxSum(subArray(A, L, left, right), M);
            answer = Math.max(answer, lSum + mSum);
            lSum += A[right] - A[left];
        }
        int mSum = maxSum(subArray(A, L, left, right), M);
        answer = Math.max(answer, lSum + mSum);
        return answer;
    }

    private static int[] subArray(int[] array, int size, int left, int right) {
        int[] newArray = new int[array.length - size];
        int idx = 0;
        for (int k = 0; k < array.length; k++) {
            if (left <= k && k < right) {
                continue;
            }
            newArray[idx++] = array[k];
        }
        return newArray;
    }

    private static int maxSum(int[] newArray, int size) {
        int sum = 0;
        for (int i = 0; i < size && i < newArray.length; i++) {
            sum += newArray[i];
        }
        int max = sum;
        for (int i = size, j = 0; i < newArray.length; i++, j++) {
            sum += newArray[i] - newArray[j];
            max = Math.max(max, sum);
        }
        return max;
    }
}
