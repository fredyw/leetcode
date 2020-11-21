package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
 */
public class Problem1546 {
    public int maxNonOverlapping(int[] nums, int target) {
        return maxNonOverlapping(nums, target, 0, nums[0], new HashMap<>());
    }

    private static int maxNonOverlapping(int[] nums, int target, int index, int sum,
                                         Map<String, Integer> memo) {
        if (index == nums.length) {
            return 0;
        }
        String key = index + "," + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int max = 0;
        int nextVal = index + 1 < nums.length ? nums[index + 1] : 0;
        if (sum == target) {
            int a = maxNonOverlapping(nums, target, index + 1, 0, memo) + 1;
            int b = maxNonOverlapping(nums, target, index + 1, nextVal, memo) + 1;
            max = Math.max(max, Math.max(a, b));
        } else {
            int a = maxNonOverlapping(nums, target, index + 1, 0, memo);
            int b = maxNonOverlapping(nums, target, index + 1, sum + nextVal, memo);
            max = Math.max(max, Math.max(a, b));
        }
        memo.put(key, max);
        return max;
    }

    public static void main(String[] args) {
        Problem1546 prob = new Problem1546();
        System.out.println(prob.maxNonOverlapping(new int[]{1,1,1,1,1}, 2)); // 2
        System.out.println(prob.maxNonOverlapping(new int[]{-1,3,5,1,4,2,-9}, 6)); // 2
        System.out.println(prob.maxNonOverlapping(new int[]{-2,6,6,3,5,4,1,2,8}, 10)); // 3
        System.out.println(prob.maxNonOverlapping(new int[]{0,0,0}, 0)); // 3
        System.out.println(prob.maxNonOverlapping(new int[]{1,1,1,1,1,3,0,8,24,5,3,23,98,5,38,5,2,45,4,5,9,9,17,5,2,25,9,23}, 9)); // 4
        System.out.println(prob.maxNonOverlapping(new int[]{4,5,9,9,5,2,9}, 9)); // 4
        System.out.println(prob.maxNonOverlapping(new int[]{1,1,5,2,4,5,1,9,9,9}, 9)); // 5
    }
}
