package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-arithmetic-sequence/
 */
public class Problem1027 {
    public int longestArithSeqLength(int[] A) {
        int answer = 0;
        Map<Integer, Integer>[] dp = new HashMap[A.length];
        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                int count = dp[j].getOrDefault(diff, 1) + 1;
                answer = Math.max(answer, count);
                dp[i].put(diff, count);
            }
        }
        return answer;
    }

//    public int longestArithSeqLength(int[] A) {
//        Integer[][] memo = new Integer[A.length][A.length];
//        int answer = 0;
//        for (int i = 0; i < A.length; i++) {
//            for (int j = i + 1; j < A.length; j++) {
//                answer = Math.max(answer, longestArithSeqLength(A, i, j, memo) + 2);
//            }
//        }
//        return answer;
//    }
//
//    private static int longestArithSeqLength(int[] a, int i, int j, Integer[][] memo) {
//        if (j == a.length) {
//            return 0;
//        }
//        if (memo[i][j] != null) {
//            return memo[i][j];
//        }
//        int max = 0;
//        for (int k = j + 1; k < a.length; k++) {
//            int diff1 = a[j] - a[i];
//            int diff2 = a[k] - a[j];
//            if (diff1 == diff2) {
//                max = Math.max(max, longestArithSeqLength(a, j, k, memo) + 1);
//            }
//        }
//        memo[i][j] = max;
//        return max;
//    }
}