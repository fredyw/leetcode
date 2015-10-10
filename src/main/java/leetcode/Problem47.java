package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/permutations-ii/
 */
public class Problem47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
        List<Integer> accu = new ArrayList<>();
        Set<List<Integer>> tmpResult = new HashSet<>();
        permutation(list, accu, tmpResult);
        result.addAll(tmpResult);
        return result;
    }

    private void permutation(List<Integer> nums, List<Integer> accu, Set<List<Integer>> result) {
        if (nums.size() == 0) {
            result.add(accu);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> newList = new ArrayList<>();
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) {
                    continue;
                }
                newList.add(nums.get(j));
            }
            List<Integer> newAccu = new ArrayList<>(accu);
            newAccu.add(nums.get(i));
            permutation(newList, newAccu, result);
        }
    }

    public static void main(String[] args) {
        Problem47 prob = new Problem47();
//        List<List<Integer>> result = prob.permuteUnique(new int[]{1, 1, 2});
//        List<List<Integer>> result = prob.permuteUnique(new int[]{3, 3, 0, 0, 2, 3, 2});
        List<List<Integer>> result = prob.permuteUnique(new int[]{1, 1, 0, 0, 1, -1, -1, 1});
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
