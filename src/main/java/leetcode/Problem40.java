package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class Problem40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> candidateList = new ArrayList();
        for (int candidate : candidates) {
            candidateList.add(candidate);
        }
        List<Integer> accu = new ArrayList<>();
        Set<List<Integer>> tmpResult = new HashSet<>();
        combination(candidateList, target, 0, 0, accu, tmpResult);
        result.addAll(tmpResult);
        return result;
    }

    private void combination(List<Integer> candidateList, int target, int idx, int sum,
                             List<Integer> accu, Set<List<Integer>> result) {
        if (sum == target) {
            result.add(accu);
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = idx; i < candidateList.size(); i++) {
            List<Integer> newAccu = new ArrayList<>(accu);
            int val = candidateList.get(i);
            newAccu.add(val);
            combination(candidateList, target, i + 1, sum + val, newAccu, result);
        }
    }
}
