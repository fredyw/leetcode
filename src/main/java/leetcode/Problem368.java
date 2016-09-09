package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-divisible-subset/
 */
public class Problem368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (tmp.size() == 0) {
                        tmp.add(nums[j]);
                    } else {
                        if (nums[j] % tmp.get(tmp.size() - 1) == 0) {
                            tmp.add(nums[j]);
                        }
                    }
                }
            }
            tmp.add(nums[i]);
            if (result.size() < tmp.size()) {
                result = tmp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem368 prob = new Problem368();
        System.out.println(prob.largestDivisibleSubset(new int[]{546, 669})); // [546]
        System.out.println(prob.largestDivisibleSubset(new int[]{1, 2, 3})); // [1, 2]
        System.out.println(prob.largestDivisibleSubset(new int[]{1, 2, 3, 6})); // [1, 2, 6]
        System.out.println(prob.largestDivisibleSubset(new int[]{1, 2, 4, 8})); // [1, 2, 4, 8]
        System.out.println(prob.largestDivisibleSubset(new int[]{1, 2, 4, 8, 9, 72})); // [1, 2, 4, 8, 72]
        System.out.println(prob.largestDivisibleSubset(new int[]{1, 2, 3, 4, 6, 24})); // [1, 2, 4, 24]
    }
}
