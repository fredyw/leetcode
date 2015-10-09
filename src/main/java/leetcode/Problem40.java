package leetcode;

import java.util.*;

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
        combination(candidateList, target, 0, 0, accu, result);
        return result;
    }

    private void combination(List<Integer> candidateList, int target, int idx, int sum,
                             List<Integer> accu, List<List<Integer>> result) {
        if (sum == target) {
            result.add(accu);
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = idx; i < candidateList.size(); i++) {
            List<Integer> newList = candidateList.subList(i, candidateList.size());
            List<Integer> newAccu = new ArrayList<>(accu);
            int val = candidateList.get(i);
            newAccu.add(val);
            combination(newList, target, idx+1, sum+val, newAccu, result);

        }
    }

    public static void main(String[] args) {
        Problem40 prob = new Problem40();
        List<List<Integer>> result = prob.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
