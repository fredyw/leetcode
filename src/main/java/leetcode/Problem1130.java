package leetcode;

/**
 * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
 */
public class Problem1130 {
    public int mctFromLeafValues(int[] arr) {
        return mctFromLeafValues(arr, 0, arr.length - 1).sum;
    }

    private static MaxSum mctFromLeafValues(int[] array, int start, int end) {
        if (start == end) {
            return new MaxSum(array[start], 0);
        }
        int max = 0;
        int sum = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            MaxSum left = mctFromLeafValues(array, start, i);
            MaxSum right = mctFromLeafValues(array, i + 1, end);
            max = Math.max(max, Math.max(left.max, right.max));
            sum = Math.min(sum, left.sum + right.sum + left.max * right.max);
        }
        return new MaxSum(max, sum);
    }

    private static class MaxSum {
        private final int max;
        private final int sum;

        public MaxSum(int max, int sum) {
            this.max = max;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        Problem1130 prob = new Problem1130();
        System.out.println(prob.mctFromLeafValues(new int[]{6, 2, 4})); // 32
        System.out.println(prob.mctFromLeafValues(new int[]{6, 2, 4, 5})); // 58
        System.out.println(prob.mctFromLeafValues(new int[]{6, 2})); // 12
        System.out.println(prob.mctFromLeafValues(new int[]{6, 2, 4, 1, 7})); // 78
    }
}
