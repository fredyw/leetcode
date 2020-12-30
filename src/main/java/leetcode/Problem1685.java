package leetcode;

/**
 * https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
 */
public class Problem1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] prefixSums = new int[nums.length];
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            prefixSums[i] = (i > 0 ? prefixSums[i - 1] : 0) + nums[i];
        }
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sumLeft = (i - 1 >= 0 ? prefixSums[i - 1] : 0);
            int sumAbsLeft = (i * nums[i]) - sumLeft;
            int sumRight = totalSum - prefixSums[i];
            int sumAbsRight = sumRight - ((nums.length - i - 1) * nums[i]);
            answer[i] = sumAbsLeft + sumAbsRight;
        }
        return answer;
    }
}
