package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/
 */
public class Problem1403 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        List<Integer> answer = new ArrayList<>();
        int tmp = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            tmp += nums[i];
            answer.add(nums[i]);
            if (sum - tmp < tmp) {
                break;
            }
        }
        return answer;
    }
}
