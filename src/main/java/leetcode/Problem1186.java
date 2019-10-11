package leetcode;

/**
 * https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
 */
public class Problem1186 {
    public int maximumSum(int[] arr) {
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            boolean negative = false;
            int sum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < 0) {
                    if (negative) {
                        break;
                    }
                    negative = true;
                } else {
                    sum += arr[j];
                }
            }
            answer = Math.max(answer, sum);
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
    }
}
