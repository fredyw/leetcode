package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class Problem39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        combinationSum(candidates, target, new ArrayList<>(), set);
        for (List<Integer> list : set) {
            result.add(list);
        }
        return result;
    }

    private void combinationSum(int[] candidates, int target, List<Integer> accu,
                                Set<List<Integer>> result) {
        if (target == 0) {
            Collections.sort(accu);
            result.add(accu);
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> newAccu = new ArrayList<>(accu);
            newAccu.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], newAccu, result);
        }
    }
}
