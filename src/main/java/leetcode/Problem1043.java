package leetcode;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/partition-array-for-maximum-sum/
 */
public class Problem1043 {
    public int maxSumAfterPartitioning(int[] A, int K) {
        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        for (int a : A) {
            set.add(a);
            if (set.size() > K) {
                set.pollLast();
            }
        }
        int answer = 0;
        int prev = 0;
        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i])) {
                answer += (i - prev) * A[i];
                prev = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1043 prob = new Problem1043();
        System.out.println(prob.maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3)); // 84
        System.out.println(prob.maxSumAfterPartitioning(new int[]{1, 15, 7, 10, 2, 5, 9}, 3)); // 84
        System.out.println(prob.maxSumAfterPartitioning(new int[]{1, 15, 7, 10, 2, 5, 9}, 4)); // 87
        System.out.println(prob.maxSumAfterPartitioning(new int[]{10, 15, 7, 9, 2, 5, 1}, 4)); // 81
        System.out.println(prob.maxSumAfterPartitioning(new int[]{10, 15, 7, 9, 2, 5, 1}, 2)); // 68
    }
}
