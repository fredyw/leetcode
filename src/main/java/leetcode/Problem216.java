package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 */
public class Problem216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        List<Integer> accu = new ArrayList<>();
        combination(numbers, k, n, 0, 0, accu, result);
        return result;
    }

    private void combination(List<Integer> numbers, int k, int n, int idx, int sum,
                             List<Integer> accu, List<List<Integer>> result) {
        if (sum == n) {
            if (k == 0) {
                result.add(accu);
            }
            return;
        }
        if (numbers.size() == 0) {
            return;
        }
        for (int i = idx; i < numbers.size(); i++) {
            int val = numbers.get(i);
            List<Integer> newAccu = new ArrayList<>(accu);
            newAccu.add(val);
            combination(numbers, k - 1, n, i + 1, sum + val, newAccu, result);
        }
    }
}
