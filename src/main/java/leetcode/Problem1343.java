package leetcode;

/**
 * https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 */
public class Problem1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int[] prefixSums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                prefixSums[i] = arr[i];
            } else {
                prefixSums[i] += prefixSums[i - 1] + arr[i];
            }
        }
        int answer = 0;
        int j = -1;
        for (int i = k - 1; i < arr.length; i++) {
            int average = (prefixSums[i] - (j == -1 ? 0 : prefixSums[j])) / k;
            if (average >= threshold) {
                answer++;
            }
            j++;
        }
        return answer;
    }
}
