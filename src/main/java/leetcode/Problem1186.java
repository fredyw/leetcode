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
//        System.out.println(Arrays.toString(forward));
//        System.out.println(Arrays.toString(backward));
        for (int i = 1; i < arr.length - 1; i++) {
            answer = Math.max(answer, forward[i - 1] + backward[i + 1]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1186 prob = new Problem1186();
        System.out.println(prob.maximumSum(new int[]{1, -2, 0, 3})); // 4
        System.out.println(prob.maximumSum(new int[]{1, -2, -2, 3})); // 3
        System.out.println(prob.maximumSum(new int[]{-1, -1, -1, -1})); // -1
        System.out.println(prob.maximumSum(new int[]{1, -2, -1, 0, 3})); // 3
        System.out.println(prob.maximumSum(new int[]{1, 2, 3})); // 6
        System.out.println(prob.maximumSum(new int[]{-4, 1, 2, -3, 3, -4, 2})); // 6
        System.out.println(prob.maximumSum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3})); // 9
    }
}
