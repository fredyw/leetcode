package leetcode;

/**
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 */
public class Problem930 {
    public int numSubarraysWithSum(int[] A, int S) {
        int sum = 0;
        int[] sums = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            sums[i] += sum;
        }
        int answer = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] < S) {
                continue;
            }
            if (sums[i] == S) {
                answer++;
            }
            int j = 0;
            while (j < i) {
                int diff = sums[i] - sums[j];
                if (diff < S) {
                    break;
                }
                if (diff == S) {
                    answer++;
                }
                j++;
            }
        }
        return answer;
    }
}
