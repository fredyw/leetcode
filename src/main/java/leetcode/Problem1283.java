package leetcode;

/**
 * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 */
public class Problem1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int answer = 0;
        int left = 1;
        int right = 1000000;
        int mid = 0;
        int maxSum = 0;
        while (left < right) {
            mid = (left + right) / 2;
            int sum = 0;
            for (int num : nums) {
                sum += -Math.floorDiv(-num, mid); // opposite of ceilDiv
            }
            if (sum > threshold) {
                left = mid + 1;
            } else {
                right = mid;
                if (sum > maxSum) {
                    answer = mid;
                    maxSum = sum;
                } else if (sum == maxSum) {
                    answer = Math.min(answer, mid);
                }
            }

        }
        return answer;
    }
}
