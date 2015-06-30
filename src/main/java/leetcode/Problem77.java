package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/combinations/
 */
public class Problem77 {
    public List<List<Integer>> combine(int n, int k) {
        Set<Set<Integer>> resultSet = new HashSet<>();
        Set<Integer> accu = new HashSet<>();
        long startTime = System.currentTimeMillis();
        combine(n, k, 0, resultSet, accu);
        System.out.println(System.currentTimeMillis() - startTime);
        List<List<Integer>> result = new ArrayList<>();
        for (Set<Integer> set : resultSet) {
            List<Integer> list = new ArrayList<>(set);
            result.add(list);
        }
        return result;
    }
    
    private void combine(int n, int k, int x, Set<Set<Integer>> result, Set<Integer> accu) {
        if (k == x) {
            result.add(accu);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (accu.contains(i)) {
                continue;
            }
            Set<Integer> newAccu = new HashSet<>(accu);
            newAccu.add(i);
            combine(n-1, k, x+1, result, newAccu);
        }
    }
    
    public static void main(String[] args) {
        Problem77 prob = new Problem77();
        List<List<Integer>> combination = prob.combine(13, 10);
        System.out.println(combination.size());
        for (List<Integer> list : combination) {
            System.out.println(list);
        }
    }
}
