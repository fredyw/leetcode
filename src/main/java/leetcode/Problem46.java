package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Problem46 {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> answer = new ArrayList<>();
        permute(num, num.length, new HashSet<>(), new ArrayList<>(), answer);
        return answer;
    }

    private static void permute(int[] num, int n, Set<Integer> duplicates, List<Integer> accu,
                                List<List<Integer>> answer) {
        if (n == 0) {
            answer.add(new ArrayList<>(accu));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (duplicates.contains(i)) {
                continue;
            }
            duplicates.add(i);
            accu.add(num[i]);
            permute(num, n - 1, duplicates, accu, answer);
            accu.remove(accu.size() - 1);
            duplicates.remove(i);
        }
    }
}
