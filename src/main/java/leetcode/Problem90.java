package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/subsets-ii/
 */
public class Problem90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        set.add(numList);
        subsets(nums, set);
        for (List<Integer> list : set) {
            result.add(list);
        }
        return result;
    }

    private void subsets(int[] nums, Set<List<Integer>> result) {
        if (nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            int[] newArray = new int[nums.length - 1];
            int idx = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                newArray[idx++] = nums[j];
                list.add(nums[j]);
            }
            if (result.add(list)) {
                subsets(newArray, result);
            }
        }
    }
}
