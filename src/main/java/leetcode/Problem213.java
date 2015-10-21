package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/house-robber-ii/
 */
public class Problem213 {
    public int rob(int[] nums) {
        int max = 0;
        if (nums.length <= 3) {
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }
        Map<Integer, Integer> memo = new HashMap<>();
        int a = rob(nums, 0, 0, memo);
        int b = rob(nums, 1, 1, memo);
        int lastVal = nums[nums.length-1];
        if (nums.length-3 % 2 == 0 || nums.length-3 % 3 == 0) {
            max = Math.max(a+lastVal, b);
        } else {
            max = Math.max(a, b+lastVal);
        }
        return max;
    }

    private int rob(int[] nums, int begIdx, int idx, Map<Integer, Integer> memo) {
        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }
        if (idx >= nums.length-1) {
            return 0;
        }
        int a = rob(nums, begIdx, idx+2, memo);
        int b = rob(nums, begIdx, idx+3, memo);
        int val = nums[idx];
        int result = Math.max(a+val, b+val);
        memo.put(idx, result);
        return result;
    }

    public static void main(String[] args) {
        Problem213 prob = new Problem213();
//        System.out.println(prob.rob(new int[]{2, 1})); // 2
//        System.out.println(prob.rob(new int[]{1, 2})); // 2
//        System.out.println(prob.rob(new int[]{1, 1, 1})); // 1
//        System.out.println(prob.rob(new int[]{1})); // 1
//        System.out.println(prob.rob(new int[]{6, 6, 4, 8, 4, 3, 3, 10})); // 27
//        System.out.println(prob.rob(new int[]{2, 1, 1, 2})); // 3
//        System.out.println(prob.rob(new int[]{2, 1, 1, 1})); // 3
//        System.out.println(prob.rob(new int[]{2, 1, 1, 4})); // 5
//        System.out.println(prob.rob(new int[]{1, 1, 3, 6, 7, 10, 7, 1, 8, 5, 9, 1, 6, 4, 3})); // 43
        System.out.println(prob.rob(new int[]{1, 3, 1, 3, 100})); // 103
    }
}
