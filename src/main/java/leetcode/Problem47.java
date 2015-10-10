package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/permutations-ii/
 */
public class Problem47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
        List<Integer> accu = new ArrayList<>();
        permutation(list, accu, result);
        return result;
    }

    private void permutation(List<Integer> nums, List<Integer> accu, List<List<Integer>> result) {
        if (nums.size() == 0) {
            result.add(accu);
            return;
        }
        Set<String> duplicates = new HashSet<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> newList = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) {
                    continue;
                }
                sb.append(nums.get(j) + "|");
                newList.add(nums.get(j));
            }
            String s = sb.toString();
            if (duplicates.contains(s)) {
                continue;
            }
            duplicates.add(s);
            List<Integer> newAccu = new ArrayList<>(accu);
            newAccu.add(nums.get(i));
            permutation(newList, newAccu, result);
        }
    }
}
