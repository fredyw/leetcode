package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 */
public class Problem907 {
    public int sumSubarrayMins(int[] A) {
        Stack<IndexValue> left = new Stack<>();
        int[] leftCounts = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            while (!left.isEmpty() && left.peek().value > A[i]) {
                left.pop();
            }
            if (!left.isEmpty()) {
                leftCounts[i] = i - left.peek().index;
            } else {
                leftCounts[i] = i + 1;
            }
            left.push(new IndexValue(i, A[i]));
        }

        Stack<IndexValue> right = new Stack<>();
        int[] rightCounts = new int[A.length];
        for (int i = A.length - 1, j = 0; i >= 0; i--, j++) {
            while (!right.isEmpty() && right.peek().value >= A[i]) {
                right.pop();
            }
            if (!right.isEmpty()) {
                rightCounts[i] = right.peek().index - i;
            } else {
                rightCounts[i] = j + 1;
            }
            right.push(new IndexValue(i, A[i]));
        }
        long answer = 0;
        for (int i = 0; i < A.length; i++) {
            answer = (answer + A[i] * leftCounts[i] * rightCounts[i]) % 1000_000_007;
        }
        return (int) answer;
    }

    private static class IndexValue {
        private final int index;
        private final int value;

        public IndexValue(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
