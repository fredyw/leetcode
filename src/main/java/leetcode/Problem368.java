package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/largest-divisible-subset/
 */
public class Problem368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> tmp = largestDivisibleSubset(nums, i, 1, new HashMap<>());
            if (result.size() < tmp.size()) {
                result = tmp;
            }
        }
        return result;
    }

    private List<Integer> largestDivisibleSubset(int[] nums, int cur, int prev,
                                                 Map<String, List<Integer>> memo) {
        if (cur == nums.length) {
            return new ArrayList<>();
        }
        String key = cur + "|" + prev;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int newPrev = prev;
        boolean found = false;
        if (prev > 0) {
            if (nums[cur] % prev == 0) {
                found = true;
                newPrev = nums[cur];
            }
        }
        List<Integer> result = largestDivisibleSubset(nums, cur + 1, newPrev, memo);
        if (found) {
            result.add(nums[cur]);
        }
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        Problem368 prob = new Problem368();
//        System.out.println(prob.largestDivisibleSubset(new int[]{546, 669})); // [546]
//        System.out.println(prob.largestDivisibleSubset(new int[]{1, 2, 3})); // [1, 2]
//        System.out.println(prob.largestDivisibleSubset(new int[]{1, 2, 3, 6})); // [1, 2, 6]
//        System.out.println(prob.largestDivisibleSubset(new int[]{1, 2, 4, 8})); // [1, 2, 4, 8]
//        System.out.println(prob.largestDivisibleSubset(new int[]{1, 2, 4, 8, 9, 72})); // [1, 2, 4, 8, 72]
//        System.out.println(prob.largestDivisibleSubset(new int[]{1, 2, 3, 4, 6, 24})); // [1, 2, 4, 24]
//        System.out.println(prob.largestDivisibleSubset(new int[]{3, 4, 16, 8})); // [4, 8, 16]
        System.out.println(prob.largestDivisibleSubset(new int[]{1, 3, 9, 18, 54, 90, 108, 180, 720, 972})); // [1, 3, 9, 18, 90, 180, 360, 720]
    }
}
