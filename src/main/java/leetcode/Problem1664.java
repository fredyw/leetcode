package leetcode;

/**
 * https://leetcode.com/problems/ways-to-make-a-fair-array/
 */
public class Problem1664 {
    public int waysToMakeFair(int[] nums) {
        int[] oddPrefixSums = new int[nums.length];
        int[] evenPrefixSums = new int[nums.length];
        int oddSum = 0;
        int evenSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i % 2 == 0) {
                if (i - 2 >= 0) {
                    evenPrefixSums[i] = evenPrefixSums[i - 2] + nums[i];
                } else {
                    evenPrefixSums[i] = nums[i];
                }
                evenSum = evenPrefixSums[i];
            } else {
                if (i - 2 >= 0) {
                    oddPrefixSums[i] = oddPrefixSums[i - 2] + nums[i];
                } else {
                    oddPrefixSums[i] = nums[i];
                }
                oddSum = oddPrefixSums[i];
            }
        }
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            int newSum = sum - nums[i];
            int left = 0;
            int right = 0;
            if (i % 2 == 0) {
                left = i - 2 >= 0 ? evenPrefixSums[i - 2] : 0;
                right = i - 1 >= 0 ? oddSum - oddPrefixSums[i - 1] : oddSum;
            } else {
                left = i - 2 >= 0 ? oddPrefixSums[i - 2] : 0;
                right = i - 1 >=  0 ? evenSum - evenPrefixSums[i - 1] : evenSum;
            }
            if (left + right == newSum - (left + right)) {
                answer++;
            }
        }
        return answer;
    }
}
