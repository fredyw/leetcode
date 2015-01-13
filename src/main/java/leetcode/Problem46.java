package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://oj.leetcode.com/problems/permutations/
 */
public class Problem46 {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        permute(result, new ArrayList<Integer>(), new HashSet<Integer>(), 0, num);
        return result;
    }
    
    private void permute(List<List<Integer>> result, List<Integer> accu,
        Set<Integer> indices, int n, int[] num) {
        if (n == num.length) {
            result.add(accu);
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (indices.contains(i)) {
                continue;
            }
            List<Integer> newAccu = new ArrayList<>();
            for (int a : accu) {
                newAccu.add(a);
            }
            newAccu.add(num[i]);
            Set<Integer> newIndices = new HashSet<>();
            for (int idx : indices) {
                newIndices.add(idx);
            }
            newIndices.add(i);
            permute(result, newAccu, newIndices, n+1, num);
        }
    }
}
