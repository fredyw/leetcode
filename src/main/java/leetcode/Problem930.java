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
            if (sums[i] == S) {
                answer++;
            }
            if (sums[i] >= S) {
                int j = 0;
                while (j < i) {
                    int diff = sums[i] - sums[j];
                    if (diff == S) {
                        answer++;
                    } else if (diff < S) {
                        break;
                    }
                    j++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem930 prob = new Problem930();
        System.out.println(prob.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2)); // 4
        System.out.println(prob.numSubarraysWithSum(new int[]{0, 1, 1, 1, 1}, 3)); // 3
    }
}
