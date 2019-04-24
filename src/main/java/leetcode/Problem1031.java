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

    public static void main(String[] args) {
        Problem1031 prob = new Problem1031();
        System.out.println(prob.maxSumTwoNoOverlap(new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2)); // 20
        System.out.println(prob.maxSumTwoNoOverlap(new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0}, 3, 2)); // 29
        System.out.println(prob.maxSumTwoNoOverlap(new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3)); // 31
        System.out.println(prob.maxSumTwoNoOverlap(new int[]{4, 0, 1}, 2, 1)); // 5
        System.out.println(prob.maxSumTwoNoOverlap(new int[]{8, 20, 6, 2, 20, 17, 6, 3, 20, 8, 12}, 5, 4)); // 108
        System.out.println(prob.maxSumTwoNoOverlap(new int[]{8, 20, 6, 2, 20, 17, 6, 3, 20, 8, 12}, 5, 4)); // 108
        System.out.println(prob.maxSumTwoNoOverlap(new int[]{12, 8, 12, 18, 19, 10, 17, 20, 6, 8, 13, 1, 19, 11, 5}, 3, 6)); // 131
    }
}
