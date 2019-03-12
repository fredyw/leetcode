package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class Problem39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        combinationSum(candidates, target, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void combinationSum(int[] candidates, int target, int index, List<Integer> accu,
                                List<List<Integer>> answer) {
        if (target == 0) {
            answer.add(new ArrayList<>(accu));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            accu.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, accu, answer);
            accu.remove(accu.size() - 1);
        }
    }
}
