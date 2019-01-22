package leetcode;

/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 */
public class Problem974 {
    public int subarraysDivByK(int[] A, int K) {
        int[] sums = new int[A.length];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            sums[i] += sum;
        }
        int answer = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] % K == 0) {
                answer++;
            }
            for (int j = i - 1; j >= 0; j--) {
                if ((sums[i] - sums[j]) % K == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem974 prob = new Problem974();
        System.out.println(prob.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5)); // 7
        // [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
    }
}
