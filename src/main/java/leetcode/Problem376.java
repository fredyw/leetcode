package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/wiggle-subsequence/
 */
public class Problem376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<String, Integer> memo = new HashMap<>();
        int a = wiggleMaxLength(nums, 1, 0, true, memo);
        int b = wiggleMaxLength(nums, 1, 0, false, memo);
        return Math.max(a, b);
    }

    private static int wiggleMaxLength(int[] nums, int idx, int prevIdx, boolean positive,
                                       Map<String, Integer> memo) {
        if (idx == nums.length) {
            return 1;
        }
        String key = idx + "|" + prevIdx + "|" + positive;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int max = 0;
        if ((nums[idx] - nums[prevIdx] > 0 && positive) ||
            (nums[idx] - nums[prevIdx] < 0 && !positive)) {
            max = Math.max(max, wiggleMaxLength(nums, idx + 1, idx, !positive, memo) + 1);
        }
        max = Math.max(max, wiggleMaxLength(nums, idx + 1, prevIdx, positive, memo));
        memo.put(key, max);
        return max;
    }

    public static void main(String[] args) {
        Problem376 prob = new Problem376();
        System.out.println(prob.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5})); // 6
        System.out.println(prob.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8})); // 7
        System.out.println(prob.wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})); // 2
        System.out.println(prob.wiggleMaxLength(new int[]{2, 1, 3})); // 3
        System.out.println(prob.wiggleMaxLength(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1})); // 2
        System.out.println(prob.wiggleMaxLength(new int[]{1})); // 1
        System.out.println(prob.wiggleMaxLength(new int[]{33, 53, 12, 64, 50, 41, 45, 21, 97, 35, 47, 92, 39, 0, 93, 55, 40, 46, 69, 42, 6, 95, 51, 68, 72, 9, 32, 84, 34, 64, 6, 2, 26, 98, 3, 43, 30, 60, 3, 68, 82, 9, 97, 19, 27, 98, 99, 4, 30, 96, 37, 9, 78, 43, 64, 4, 65, 30, 84, 90, 87, 64, 18, 50, 60, 1, 40, 32, 48, 50, 76, 100, 57, 29, 63, 53, 46, 57, 93, 98, 42, 80, 82, 9, 41, 55, 69, 84, 82, 79, 30, 79, 18, 97, 67, 23, 52, 38, 74, 15})); // 67
    }
}
