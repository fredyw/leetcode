package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/subsets-ii/
 */
public class Problem90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> sets = new HashSet<>();
        subsetsWithDup(nums, 0, new ArrayList<>(), sets);
        return new ArrayList<>(sets);
    }

    private static void subsetsWithDup(int[] nums, int index, List<Integer> accu, Set<List<Integer>> result) {
        List<Integer> tmp = new ArrayList<>(accu);
        Collections.sort(tmp);
        result.add(tmp);
        for (int i = index; i < nums.length; i++) {
            accu.add(nums[i]);
            subsetsWithDup(nums, i + 1, accu, result);
            accu.remove(accu.size() - 1);
        }
    }
}
