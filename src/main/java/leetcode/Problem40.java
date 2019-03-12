package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class Problem40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> sets = new HashSet<>();
        combinationSum2(candidates, target, 0, new ArrayList<>(), sets);
        return new ArrayList<>(sets);
    }

    private void combinationSum2(int[] candidates, int target, int index, List<Integer> accu, Set<List<Integer>> sets) {
        if (target == 0) {
            List<Integer> newList = new ArrayList<>(accu);
            Collections.sort(newList);
            sets.add(newList);
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            accu.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], i + 1, accu, sets);
            accu.remove(accu.size() - 1);
        }
    }
}
