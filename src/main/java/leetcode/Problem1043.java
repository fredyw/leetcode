package leetcode;

/**
 * https://leetcode.com/problems/partition-array-for-maximum-sum/
 */
public class Problem1043 {
    public int maxSumAfterPartitioning(int[] A, int K) {
        return maxSumAfterPartitioning(A, K, 0, new Integer[A.length]);
    }

    private static int maxSumAfterPartitioning(int[] array, int k, int index, Integer[] memo) {
        if (index >= array.length) {
            return 0;
        }
        if (memo[index] != null) {
            return memo[index];
        }
        int answer = array[index];
        int[] max = new int[k];
        for (int i = 0, j = index; j < index + k && j < array.length; i++, j++) {
            if (i == 0) {
                max[i] = array[j];
            } else {
                max[i] = Math.max(max[i - 1], array[j]);
            }
        }
        for (int i = 0; i < k; i++) {
            if (index + i >= array.length) {
                break;
            }
            int val = maxSumAfterPartitioning(array, k, index + i + 1, memo) + (max[i] * (i + 1));
            answer = Math.max(answer, val);
        }
        memo[index] = answer;
        return answer;
    }
}
