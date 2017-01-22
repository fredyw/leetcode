package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/increasing-subsequences/
 */
public class Problem491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Set<List<Integer>> result = new HashSet<>();
        findSubsequences(list, result);
        return new ArrayList<>(result);
    }

    private static void findSubsequences(List<Integer> nums, Set<List<Integer>> result) {
        if (nums.size() <= 1) {
            return;
        }
        result.add(nums);
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> newList = new ArrayList<>();
            if (i - 1 >= 0) {
                newList.addAll(nums.subList(0, i));
            }
            if (i + 1 <= nums.size() - 1) {
                newList.addAll(nums.subList(i + 1, nums.size()));
            }
            findSubsequences(newList, result);
        }
    }

    public static void main(String[] args) {
        Problem491 prob = new Problem491();
        System.out.println(prob.findSubsequences(new int[]{1, 1, 1})); // [[1, 1], [1, 1, 1]]
        System.out.println(prob.findSubsequences(new int[]{1, 2, 2})); // [[1, 2], [2, 2], [1, 2, 2]]
        System.out.println(prob.findSubsequences(new int[]{4, 6, 7, 7})); // [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
        System.out.println(prob.findSubsequences(new int[]{4, 3, 2, 1})); // []
        System.out.println(prob.findSubsequences(new int[]{4, 3, 1, 2})); // [[1, 2]]
    }
}
