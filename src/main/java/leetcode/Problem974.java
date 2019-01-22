package leetcode;

/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 */
public class Problem974 {
    public int subarraysDivByK(int[] A, int K) {
        int total = 0;
        int[] count = new int[K];
        count[0] = 1;
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            total += A[i];
            int mod = total % K;
            // Make the mod positive.
            if (mod < 0) {
                mod += K;
            }
            answer += count[mod];
            count[mod]++;
        }
        return answer;
    }
}
