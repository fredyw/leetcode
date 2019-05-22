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
        int max = 0;
        for (int i = 0; i < k; i++) {
            if (index + i >= array.length) {
                break;
            }
            max = Math.max(max, array[index + i]);
            int val = maxSumAfterPartitioning(array, k, index + i + 1, memo) + (max * (i + 1));
            answer = Math.max(answer, val);
        }
        memo[index] = answer;
        return answer;
    }
}
