package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/smallest-range-ii/
 */
public class Problem910 {
    public int smallestRangeII(int[] A, int K) {
        if (A.length == 1) {
            return 0;
        }
        Arrays.sort(A);
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            if ((A[i] + K) == (A[i + 1] + K)) {
                continue;
            }
            int hi = A[i] + K;
            int lo = A[i + 1] - K;
            answer = Math.min(answer, Math.abs(hi - lo));
        }
        answer = Math.min(answer, Math.abs(A[A.length - 1] - A[0]));
        return answer;
    }

    public static void main(String[] args) {
        Problem910 prob = new Problem910();
//        System.out.println(prob.smallestRangeII(new int[]{1}, 0)); // 0
//        System.out.println(prob.smallestRangeII(new int[]{1}, 5)); // 0
//        System.out.println(prob.smallestRangeII(new int[]{0, 10}, 2)); // 6
//        System.out.println(prob.smallestRangeII(new int[]{1, 3, 6}, 3)); // 3
//        System.out.println(prob.smallestRangeII(new int[]{1, 3, 7, 4, 1, 10, 8, 11}, 4)); // 5
//        System.out.println(prob.smallestRangeII(new int[]{2, 7, 2}, 1)); // 3
//        System.out.println(prob.smallestRangeII(new int[]{7, 8, 8}, 5)); // 1
        System.out.println(prob.smallestRangeII(new int[]{1, 3, 10}, 4)); // 2
    }
}
