package leetcode;

/**
 * https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
 */
public class Problem1186 {
    public int maximumSum(int[] arr) {
        int answer = arr[0];
        int maxSoFar = arr[0];
        int[] forward = new int[arr.length];
        forward[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxSoFar = Math.max(arr[i], maxSoFar + arr[i]);
            forward[i] = maxSoFar;
            answer = Math.max(answer, maxSoFar);
        }
        maxSoFar = arr[arr.length - 1];
        int[] backward = new int[arr.length];
        backward[backward.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            maxSoFar = Math.max(arr[i], maxSoFar + arr[i]);
            backward[i] = maxSoFar;
            answer = Math.max(answer, maxSoFar);
        }
        for (int i = 1; i < arr.length - 1; i++) {
            answer = Math.max(answer, forward[i - 1] + backward[i + 1]);
        }
        return answer;
    }
}
