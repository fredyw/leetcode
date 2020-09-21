package leetcode;

/**
 * https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 */
public class Problem1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] prefixSum = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                prefixSum[i] = arr[i];
            } else {
                prefixSum[i] = prefixSum[i - 1] + arr[i];
            }
        }
        int answer = 0;
        for (int len = 1; len <= arr.length; len += 2) {
            for (int i = 0; i < arr.length; i++) {
                if (i + len - 1 < arr.length) {
                    answer += prefixSum[i + len - 1] - (i - 1 >= 0 ? prefixSum[i - 1] : 0);
                }
            }
        }
        return answer;
    }
}
