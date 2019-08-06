package leetcode;

/**
 * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
 */
public class Problem1130 {
    public int mctFromLeafValues(int[] arr) {
        return mctFromLeafValues(arr, 0, arr.length - 1, new MaxSum[arr.length][arr.length]).sum;
    }

    private static MaxSum mctFromLeafValues(int[] array, int start, int end, MaxSum[][] memo) {
        if (start == end) {
            return new MaxSum(array[start], 0);
        }
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        int max = 0;
        int sum = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            MaxSum left = mctFromLeafValues(array, start, i, memo);
            MaxSum right = mctFromLeafValues(array, i + 1, end, memo);
            max = Math.max(max, Math.max(left.max, right.max));
            sum = Math.min(sum, left.sum + right.sum + left.max * right.max);
        }
        MaxSum answer = new MaxSum(max, sum);
        memo[start][end] = answer;
        return answer;
    }

    private static class MaxSum {
        private final int max;
        private final int sum;

        public MaxSum(int max, int sum) {
            this.max = max;
            this.sum = sum;
        }
    }
}
