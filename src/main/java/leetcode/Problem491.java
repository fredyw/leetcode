package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/increasing-subsequences/
 */
public class Problem491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Set<List<Integer>> result = new HashSet<>();
        findSubsequences(list, 0, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    private static void findSubsequences(List<Integer> nums, int idx, List<Integer> accu, Set<List<Integer>> result) {
        if (accu.size() >= 2) {
            result.add(accu);
        }
        for (int i = idx; i < nums.size(); i++) {
            if (!accu.isEmpty()) {
                if (accu.get(accu.size() - 1) <= nums.get(i)) {
                    List<Integer> newAccu = new ArrayList<>(accu);
                    newAccu.add(nums.get(i));
                    findSubsequences(nums, i + 1, newAccu, result);
                }
            } else {
                List<Integer> newAccu = new ArrayList<>();
                newAccu.add(nums.get(i));
                findSubsequences(nums, i + 1, newAccu, result);
            }
        }
    }
}
