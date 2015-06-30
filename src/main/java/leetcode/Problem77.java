package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 */
public class Problem77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> accu = new ArrayList<>();
        combine(n, k, 1, result, accu);
        return result;
    }
    
    private void combine(int n, int k, int x, List<List<Integer>> result, List<Integer> accu) {
        if (accu.size() == k) {
            result.add(accu);
            return;
        }
        for (int i = x; i <= n; i++) {
            List<Integer> newAccu = new ArrayList<>(accu);
            newAccu.add(i);
            combine(n, k, i+1, result, newAccu);
        }
    }
}
